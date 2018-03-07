package io.pax.starstone.dao;

import io.pax.starstone.domain.Game;
import io.pax.starstone.domain.Winner;

import java.sql.*;

public class WinnerDao {

    Connector connector = new Connector();

    public int defineWinner(String result) throws SQLException {

        //Winner winner = new Winner(String);

        Connection conn = this.connector.getConnection();


        String query = "INSERT INTO winner (name) VALUES (?)";

        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        // GeneralDeck generalDeck = new GeneralDeck();

        statement.setString(1, result);

        statement.executeUpdate();

        ResultSet keys = statement.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);

        keys.close();
        statement.close();
        conn.close();
        return id;
    }

    public static void main(String[] args) throws SQLException {
        Game game = new Game();
        String result = game.defineWinner();
        WinnerDao dao = new WinnerDao();
        int id = dao.defineWinner(result);
        System.out.println(id);
        System.out.println(dao.defineWinner(result));
    }
}
