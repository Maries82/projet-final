package io.pax.starstone.webservice;

import io.pax.starstone.dao.DeckDao;
import io.pax.starstone.domain.Card;
import io.pax.starstone.domain.Hand;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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

    @POST
    public Hand createHand(List<Card> cards) {

        List<Card> handList = new ArrayList<>();
        String color = cards.get(0).getColor();

        for (int index = 0; index < 8; index++){
            handList.add(new Card(
                    cards.get(index).getOrder(),
                    cards.get(index).getUp(),
                    cards.get(index).getRight(),
                    cards.get(index).getDown(),
                    cards.get(index).getLeft(),
                    color));
        }

        Collections.sort(handList);

        Hand hand = new Hand(color, handList);
        System.out.println(hand);
        return hand;
    }


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
