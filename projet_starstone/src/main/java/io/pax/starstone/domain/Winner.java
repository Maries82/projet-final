package io.pax.starstone.domain;

public class Winner extends Game{

String name;

    public Winner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
