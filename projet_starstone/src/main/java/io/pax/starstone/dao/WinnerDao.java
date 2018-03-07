package io.pax.starstone.dao;

import io.pax.starstone.domain.Game;
import io.pax.starstone.domain.Winner;

import javax.xml.registry.infomodel.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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



    public List<Winner> getWinners() throws SQLException {

        List<Winner> result = new ArrayList<>();
        Connection conn = this.connector.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM winner");

        while (rs.next()) {
            String name = rs.getString("name");
            int id = rs.getInt("id");
            Winner winner = new Winner(id, name);
            result.add(winner);

        }

        rs.close();
        stmt.close();
        conn.close();

        return result;

    }


    public static void main(String[] args) throws SQLException {
        Game game = new Game();
//        String result = game.defineWinner();
        WinnerDao dao = new WinnerDao();
//        int id = dao.defineWinner(result);
//        System.out.println(id);
//        System.out.println(dao.defineWinner(result));
        System.out.println(dao.getWinners());
    }
}
