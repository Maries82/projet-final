package io.pax.starstone.domain;


public class Card implements Comparable<Card>{

    int up, right, down, left, order;

    String name, color;


    public Card(){
    }


    public Card(int up, int right, int down, int left) {
        super();
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.name = "" + up + right + down + left;
        this.color = "";
        this.order = 0;
    }

    public Card(int order, int up, int right, int down, int left, String color) {
        super();
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.name = "" + up + right + down + left;
        this.color = color;
        this.order = order;
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


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Card " + this.name+", "+this.color;
    }


    @Override
    public int compareTo(Card card) {
        if (this.getOrder() > card.getOrder()){
            return 1;
        } else if (this.getOrder() == card.getOrder()){
            return 0;
        } else {
            return -1;
        }
    }

    public boolean hasDifferentColor(Card card){
        if (this.getColor().equals(card.getColor()))
            return false;
        return true;
    }
}

