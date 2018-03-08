package io.pax.starstone.domain;

import io.pax.starstone.dao.DeckDao;
import io.pax.starstone.dao.WinnerDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Game {


    Hand handPrincess, handZerg;
    Grid grid;


    public Game(){

    }
    public Game(Hand handPrincess, Hand handZerg, Grid grid) {
        this.handPrincess = handPrincess;
        this.handZerg = handZerg;
        this.grid = grid;
    }

    public Game(Hand handPrincess, Hand handZerg) {
        this.handPrincess = handPrincess;
        this.handZerg = handZerg;
        this.grid = new Grid();
    }


    // génère au hasard une main de 6 cartes de la couleur du joueur donné
    public static Hand generateRandomHand(String color){
        List<Card> liste = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            Double d = Math.random()*489;
            int r = d.intValue();
            Card card = GeneralDeck.createCardsStatic().get(r);
            card.setOrder(i);
            card.setColor(color);
            liste.add(card);
        }
        Hand randomHand = new Hand(liste);
        return randomHand;
    }

/*    // génère une main de 6 cartes au hasard
    public static Hand generateRandomHand(){
        List<Card> liste = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            Double d = Math.random()*489;
            int r = d.intValue();
            Card card = GeneralDeck.createCardsStatic().get(r);
            liste.add(card);
        }
        Hand randomHand = new Hand(liste);
        return randomHand;
    }*/

    public Hand getHandPrincess() throws SQLException {
        DeckDao dao = new DeckDao();
        Hand handPrincess = new Hand(dao.getPrincessDeck().get(0).getColor(), dao.getPrincessDeck());
        return handPrincess;
    }

    public void setHandPrincess(Hand handPrincess) {
        this.handPrincess = handPrincess;
    }

    public Hand getHandZerg() throws SQLException {
        DeckDao dao = new DeckDao();
        Hand handZerg = new Hand(dao.getZergDeck().get(0).getColor(), dao.getZergDeck());
        return handZerg;
    }

    public void setHandZerg(Hand handZerg) {
        this.handZerg = handZerg;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }


    public boolean isFinished (){
        if (this.grid != null){
            if (this.grid.isFull()){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public String defineWinner() throws SQLException {
        WinnerDao dao = new WinnerDao();

        if (isFinished()){
            if (this.grid.maxOfColors() == "equality"){
                String equality = "There is an equality ! You should restart a game.";
                dao.defineWinner(equality);
                return equality;
            } else {
                String result = "The winner is " + this.grid.maxOfColors();
                dao.defineWinner(result);
                return result;
            }
        } else {
            return "The Game is not finished";
        }


    }

    public void generateNewRandomGame(){
        this.handPrincess = generateRandomHand("princess");
        this.handZerg = generateRandomHand("zerg");
        this.grid = new Grid();
    }

    public void playGame(){
        List<Card> cardsToBePlayed = new ArrayList<>();
        generateCardsToBePlayed(cardsToBePlayed);

        int count = 0;
        for (int j = 3; j > -1; j--) {
            for (int i = 0; i < 4; i++){
                //System.out.println(cardsToBePlayed.get(count));
                this.grid.insertCard(i,j,cardsToBePlayed.get(count));
                System.out.println(this.grid.toString());
                count++;
            }

        }

    }

    public void playGameWithRandomCardInsertion(){
        List<Card> cardsToBePlayed = new ArrayList<>();
        generateCardsToBePlayed(cardsToBePlayed);

        int count = 0;
        while (!this.grid.isFull()){
            Cell cell = this.grid.insertCardToRandomEmptyCell();
            this.grid.insertCard(cell.getX(),cell.getY(), cardsToBePlayed.get(count));
            System.out.println(this.grid.toString());
            count++;
        }



    }

    private void generateCardsToBePlayed(List<Card> cardsToBePlayed) {
        for (int i = 0; i < handZerg.getCards().size() ; i++) {

            Card cardZ = this.handZerg.getCards().get(i);
            Card cardP = this.handPrincess.getCards().get(i);
            int idCard = 2*i;

            if (i<4 || (i> 7 && i<12)){
                cardsToBePlayed.add(cardZ);
                cardsToBePlayed.add(cardP);
            }
            else {
                cardsToBePlayed.add(cardP);
                cardsToBePlayed.add(cardZ);
            }

        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        int scoreZerg = 0;
        int scorePrincess = 0;



        for (int i = 0; i <100 ; i++) {
            game.generateNewRandomGame();
            game.playGameWithRandomCardInsertion();

            String winner = null;
            try {
                winner = game.defineWinner();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(winner.equals("princess"))
                scorePrincess++;
            if(winner.equals("zerg"))
                scoreZerg++;

        }

        System.out.println("scoreZerg = "+scoreZerg+"\n"+"scorePrincess = "+scorePrincess);
    }
}
