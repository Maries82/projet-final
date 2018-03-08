package io.pax.starstone.webservice;


import io.pax.starstone.business.HandBusiness;
import io.pax.starstone.domain.Card;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("result")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameWs {

    @GET
    @Path("list")
    public List<Card> getResultList() throws SQLException {

        return HandBusiness.RESULT;
    }

    @GET
    @Path("winner")
    public String getResultWinner() throws SQLException {

        return HandBusiness.WINNER;
    }


}
