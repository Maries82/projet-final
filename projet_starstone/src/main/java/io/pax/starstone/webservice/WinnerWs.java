package io.pax.starstone.webservice;
import io.pax.starstone.dao.WinnerDao;
import io.pax.starstone.domain.Winner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("game")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WinnerWs {

    @GET
    @Path("winner")
    public List<Winner> getWinners() throws SQLException {

        WinnerDao dao = new WinnerDao();
        return  dao.getWinners();

    }


    @POST
    public List<Winner> createWinner() {
        List<Winner> winners = new ArrayList<>();
        return winners;
    }
}
