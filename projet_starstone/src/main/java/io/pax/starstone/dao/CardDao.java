package io.pax.starstone.dao;

/**
 * Created by AELION on 05/03/2018.
 */

/**
 * Created by AELION on 05/03/2018.
 */
public class CardDao {

    Connector connector = new Connector();

/*    public int createCard() throws SQLException {


        System.out.println(query);

        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        GeneralDeck generalDeck = new GeneralDeck();

        statement.setInt(1, GeneralDeck);
        statement.setInt(2, adminId);
        statement.setInt(2, adminId);
        statement.setInt(2, adminId);

        statement.executeUpdate();
        ResultSet keys = statement.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);


        statement.close();
        conn.close();

        return id;
    }*/



}
