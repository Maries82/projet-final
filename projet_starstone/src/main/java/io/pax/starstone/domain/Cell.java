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
        if (null == this.getCard()){
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

   // retourne vrai si un des nombres en parametres aditionées aux coordonnées de la case fait dépasser de la grille
    public boolean isOutOfGrid(int i, int j){
        if(this.getX() + i > 4 || this.getX() + i < 0 || this.getY() + j > 4 || this.getY() + j < 0)
            return true;
        return false;
    }

    public boolean cardHasSameColor(Cell cell){
        if (this.getCard().getColor().equals(cell.getCard().getColor()))
            return true;
        return false;
    }

    public String toString(){
        if (this.isEmpty()){
            return "Cell [ X="+ this.getX()+", Y="+this.getY()+", nullCard ]";
        }
        return "Cell [ X="+ this.getX()+", Y="+this.getY()+", "+this.getCard()+" ]";

    }
}
