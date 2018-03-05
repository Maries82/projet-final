package io.pax.starstone.domain;


public class Card {

    int up;
    int right;
    int down;
    int left;

    String name;

    public Card(int up, int right, int down, int left) {
        super();
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.name = "" + up + right + down + left;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card " + this.name;
    }



}
