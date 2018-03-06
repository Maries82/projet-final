package io.pax.starstone.webservice;


import io.pax.starstone.domain.Hand;

import javax.ws.rs.core.Application;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class StarstoneApplication extends Application {


    public static void main(String[] args) {

        Hand hand = new Hand();


    }

}