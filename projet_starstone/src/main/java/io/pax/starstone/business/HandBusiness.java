package io.pax.starstone.business;

import io.pax.starstone.domain.Card;
import io.pax.starstone.domain.Hand;

import java.util.ArrayList;
import java.util.List;

public class HandBusiness {


    public static Hand createHand(String color, List<Card> cards){

        Hand hand = new Hand(color, cards);
        //System.out.println(hand);
        return hand;
    }


    public static void main(String[] args) {

        List<Card> cards = new ArrayList<>();
        String color = "zerg";
        Card card = new Card(1,1,9,9);


        cards.add(card);
        System.out.println(cards.size());

        System.out.println(HandBusiness.createHand(color,cards));
    }

}




