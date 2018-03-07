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


    // génère au hasard une main de 6 cartes de la couleur du joueur donné
    public static Hand generateRandomHand(String color){
        List<Card> liste = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            Double d = Math.random()*489;
            int r = d.intValue();
            Card card = GeneralDeck.createCardsStatic().get(r);
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

}
