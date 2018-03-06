package io.pax.starstone.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AELION on 05/03/2018.
 */
public class Deck  {

    List<Card> cards = new ArrayList<>();

    public Deck() {
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "GeneralDeck [cards=" + cards + "]";
    }


    public static List<Card> generate10RandomCards(){

        List<Card> liste = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            Double d = Math.random()*489;
            int r = d.intValue();
            Card card = GeneralDeck.generalDeck.get(r);
            liste.add(card);
        }

        return liste;
    }

}
