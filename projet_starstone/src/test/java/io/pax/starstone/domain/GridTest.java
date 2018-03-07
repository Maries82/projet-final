package io.pax.starstone.domain;

import org.junit.Test;

public class GridTest {

    @Test
    public static void insertCard() {

        Game game = new Game();
    game.generateNewRandomGame();
    game.playGame();

        System.out.println("////////////////////////////////////////////////// \n /////////////////////////////////////////////////////");
        System.out.println(game.getGrid().toString());





    }

    public static void main(String[] args) {
        insertCard();
    }
}