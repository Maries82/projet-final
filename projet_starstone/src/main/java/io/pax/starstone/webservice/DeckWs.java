package io.pax.starstone.webservice;

import io.pax.starstone.dao.DeckDao;
import io.pax.starstone.domain.Card;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by AELION on 05/03/2018.
 */

@Path("general")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeckWs {

    @GET
    @Path("princess")
    public List<Card> getPrincessDeck() throws SQLException {
        DeckDao dao = new DeckDao();
        return dao.getPrincessDeck();
    }

    @GET
    @Path("zerg")
    public List<Card> getZergDeck() throws SQLException {
        DeckDao dao = new DeckDao();
        return dao.getZergDeck();
    }

/*    @POST
    public Hand createHand() throws SQLException {
        try {

            int id = new DeckDao().createDeck();
            return new GeneralDeck();
        } catch (SQLException e) {
            throw e;
        }
    }*/


/*    @POST
    public GeneralDeck createDeck() throws SQLException {
        //GeneralDeck deck = new GeneralDeck();

        try {
            int id = new DeckDao().createDeck();
            return new GeneralDeck();
        } catch (SQLException e) {
            throw e;
        }

    }*/


}
