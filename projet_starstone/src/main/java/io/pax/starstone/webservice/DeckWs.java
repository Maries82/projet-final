package io.pax.starstone.webservice;

import io.pax.starstone.business.HandBusiness;
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
    public List<Hand> createHand(List<Card> princessHand, List<Card> zergHand) {

        List<Card> princessHandList = new ArrayList<>();
        List<Card> zergHandList = new ArrayList<>();

        List<Hand> hands = new ArrayList<>();

        String colorZ = princessHand.get(0).getColor();
        String colorP = zergHand.get(0).getColor();

        for (int index = 0; index < 8; index++){
            princessHandList.add(new Card(
                    princessHand.get(index).getOrder(),
                    princessHand.get(index).getUp(),
                    princessHand.get(index).getRight(),
                    princessHand.get(index).getDown(),
                    princessHand.get(index).getLeft(),
                    colorP));
        }

        Collections.sort(princessHandList);
        Hand pHand = new Hand(colorP, princessHandList);

        for (int index = 0; index < 8; index++){
            zergHandList.add(new Card(
                    zergHand.get(index).getOrder(),
                    zergHand.get(index).getUp(),
                    zergHand.get(index).getRight(),
                    zergHand.get(index).getDown(),
                    zergHand.get(index).getLeft(),
                    colorZ));
        }

        Collections.sort(zergHandList);
        Hand zHand = new Hand(colorZ, zergHandList);

        hands.add(pHand);
        hands.add(zHand);

        List<Hand> handList = new HandBusiness().getTwoHands(pHand,zHand);

        System.out.println(hands);
        System.out.println(handList);
        return hands;
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
