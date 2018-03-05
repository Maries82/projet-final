package io.pax.starstone.dao;

import io.pax.starstone.domain.Card;
import io.pax.starstone.domain.GeneralDeck;

import java.sql.*;
import java.util.List;

/**
 * Created by AELION on 05/03/2018.
 */
public class DeckDao {

    Connector connector = new Connector();

    public int createDeck() throws SQLException {

        GeneralDeck deck = new GeneralDeck();
        List<Card> cards = deck.getCards();

        Connection conn = this.connector.getConnection();
        PreparedStatement statement = null;

        for (Card carte : cards){
            String query = "INSERT INTO global_deck (up_side,right_side,down_side,left_side) VALUES (?,?,?,?)";

            System.out.println(query);


            statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            GeneralDeck generalDeck = new GeneralDeck();

            statement.setInt(1, carte.getUp());
            statement.setInt(2, carte.getRight());
            statement.setInt(3, carte.getDown());
            statement.setInt(4, carte.getLeft());

            statement.executeUpdate();
            System.out.println(carte);
        }

        ResultSet keys = statement.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);

        statement.close();
        conn.close();

        return id;
    }

    public static void main(String[] args) throws SQLException {
        DeckDao dao = new DeckDao();
        dao.createDeck();
    }

}

