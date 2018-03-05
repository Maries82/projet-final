package io.pax.starstone.domain;

import java.util.ArrayList;
import java.util.List;

public class GeneralDeck {

    List<Card> cards = new ArrayList<>();

    public GeneralDeck() {
        super();
        this.cards = createCards();
    }

    public List<Card> createCards (){

        List<Card> results = new ArrayList<>();
        int count = 0;

        for (int up = 1; up < 10 ; up++){
            for (int right = 1; right < 10 ; right++){
                for (int down = 1; down < 10 ; down++){
                    for (int left = 1; left < 10 ; left++){
                        if (up + right + down + left == 20){
                            Card carte = new Card(up, right, down, left);
                            results.add(carte);
                            count++;
                        }

                    }

                }
            }
        }


        //System.out.println(count);


        return results;

    }

    @Override
    public String toString() {
        return "GeneralDeck [cards=" + cards + "]";
    }


    public  List<Card> getCards (){
        return this.cards;
    }

}