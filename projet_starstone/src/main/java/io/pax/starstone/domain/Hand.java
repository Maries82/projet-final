package io.pax.starstone.domain;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    List<Card> cards = new ArrayList<>();
    String color;

    public Hand() {

    }

    public Hand (String color, List<Card> cards){
        this.color = color;
        this.cards = cards;
    }

    public Hand (List<Card> cards){
        this.color = cards.get(0).getColor();
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Hand{}";
    }
}
