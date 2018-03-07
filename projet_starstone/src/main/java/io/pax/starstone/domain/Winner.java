package io.pax.starstone.domain;

public class Winner {

String name;
int id;

    public Winner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Winner(int id, String name) {
        this.id= id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Winner{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
