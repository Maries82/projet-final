package io.pax.starstone.domain;

public class Cell {

    int x,y;
    Card card;

    public Cell(int x, int y ) {
        this.x = x;
        this.y = y;

    }




    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isEmpty(){
        if (this.card.equals(null)){
            return true;
        }
        else return false;
    }

    // renvoie : 0 si la carte en param est en haut
    // renvoie : 1 si la carte en param est à droite
    // renvoie : 2 si la carte en param est en bas
    // renvoie : 3 si la carte en param est à gauche


   public int returnAdjacentCellPosition(Cell cell){
        if (this.getY() < cell.getY()){
            return 0;
        }
       if (this.getX() < cell.getX()){
           return 1;
       }
       if (this.getY() > cell.getY()){
           return 2;
       }
       if (this.getX() > cell.getX()){
           return 3;
       }


       return 0;
   }
}
