package io.pax.starstone.domain;

import org.junit.Test;

public class GridTest {

    @Test
    public static void insertCard() {

Grid grid = new Grid();
Card card1 = new Card(0,5,5,5,5,"zerg");
Card card2 = new Card(0,4, 4,4,4,"princess");
Card card3 = new Card(0,6,6,6,6,"zerg");


grid.insertCard(2,3,card2);
        System.out.println(card2);
grid.insertCard(2,2,card1);
        System.out.println(card2);
    }

    public static void main(String[] args) {
        insertCard();
    }
}