package io.pax.starstone.domain;

import org.junit.Test;

import java.sql.SQLException;

public class GridTest {

    @Test
    public static void insertCard() {

        Game game = new Game();
    game.generateNewRandomGame();
    game.playGame();


        System.out.println("////////////////////////////////////////////////// \n /////////////////////////////////////////////////////");
        System.out.println(game.getGrid().toString());

        try {
            System.out.println(game.defineWinner());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        insertCard();
    }
}