package io.pax.starstone.dao;

import io.pax.starstone.domain.Card;
import io.pax.starstone.domain.Deck;
import io.pax.starstone.domain.GeneralDeck;

import java.sql.*;
import java.util.ArrayList;
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

           // GeneralDeck generalDeck = new GeneralDeck();

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

    public List<Card> getPrincessDeck () throws SQLException {

        List<Card> result = new ArrayList<>();

        Connection conn = this.connector.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM princess_deck p JOIN global_deck g ON p.id_card = g.id_card");

        while (rs.next()) {
            int cardId = rs.getInt("p.id_card");
            int up = rs.getInt("g.up_side");
            int right = rs.getInt("g.right_side");
            int down = rs.getInt("g.down_side");
            int left = rs.getInt("g.left_side");
            Card card = new Card(up, right, down, left);
            card.setColor("princess");
            result.add(card);
        }

        for (Card card : Deck.generate10RandomCards()){
            card.setColor("princess");
            result.add(card);
        }


        rs.close();
        stmt.close();
        conn.close();

        return result;
    }

    public List<Card> getZergDeck () throws SQLException {

        List<Card> result = new ArrayList<>();

        Connection conn = this.connector.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM zerg_deck z JOIN global_deck g ON z.id_card = g.id_card");

        while (rs.next()) {
            int cardId = rs.getInt("z.id_card");
            int up = rs.getInt("g.up_side");
            int right = rs.getInt("g.right_side");
            int down = rs.getInt("g.down_side");
            int left = rs.getInt("g.left_side");
            Card card = new Card(up, right, down, left);
            card.setColor("zerg");
            result.add(card);
        }

        for (Card card : Deck.generate10RandomCards()){
            card.setColor("zerg");
            result.add(card);
        }

        rs.close();
        stmt.close();
        conn.close();

        return result;
    }










    public static void main(String[] args) throws SQLException {
        DeckDao dao = new DeckDao();
        //dao.createDeck();

        //System.out.println(dao.getPrincessDeck());

    }

}
