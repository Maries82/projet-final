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

    public static List<Hand> getTwoHands(Hand pHand, Hand zHand){
        List<Hand> hands = new ArrayList<>();

        hands.add(pHand);
        hands.add(zHand);

        return hands;
    }


    public static void main(String[] args) {

        List<Card> pCards = new ArrayList<>();
        List<Card> zCards = new ArrayList<>();

        String colorZ = "zerg";
        String colorP = "princess";

        Card card = new Card(1,1,9,9, colorP);
        Card card2 = new Card(1,2,8,9,colorP);

        Card card3 = new Card(1,2,3,4,colorZ);
        Card card4 = new Card(4,5,5,6,colorZ);


        pCards.add(card);
        pCards.add(card2);
        zCards.add(card3);
        zCards.add(card4);

        Hand pHand = new Hand(colorP, pCards);
        Hand zHand = new Hand(colorZ, zCards);

        System.out.println(pCards.size());
        System.out.println(zCards.size());

        //System.out.println(HandBusiness.createHand(color,cards));
        System.out.println(HandBusiness.getTwoHands(pHand,zHand));

    }

}




