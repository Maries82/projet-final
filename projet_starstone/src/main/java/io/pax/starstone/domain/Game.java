package io.pax.starstone.domain;

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

    // génère une main de 6 cartes au hasard
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
    }

    public Hand getHandPrincess() {
        return handPrincess;
    }

    public void setHandPrincess(Hand handPrincess) {
        this.handPrincess = handPrincess;
    }

    public Hand getHandZerg() {
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
}
