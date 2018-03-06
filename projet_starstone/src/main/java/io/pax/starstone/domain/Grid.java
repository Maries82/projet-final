package io.pax.starstone.domain;

public class Grid {

    public final static int NBR_CASES_COTE = 4;
    public Cell[][] grid;

    public Grid(Cell[][] grid) {
        this.grid = grid;
    }



    public void insertCard(int x, int y, Card card) {

        // placement de la carte sur
        grid[x][y].setCard(card);

        // recherche des cases adjacentes à la case séléctionnée
        for (int i = -1; i < 2; i += 2) {
            for (int j = -1; j < 2; j += 2) {

                // gestion des cases hors tableau
                if (x + i > 3 || x + j > 3 || x + i < 0 || x + j < 0 || y + i > 3 || y + j > 3 || y + i < 0 || y + j < 0) {
                    System.out.println("la case est hors tableau");
                }

                // je vérifie que la case adjacente possède une carte
                else if (!(this.grid[x + i][y + j].isEmpty())) {

                    // je regarde si la carte adjacente est de couleur differente
                    if ((grid[x + i][y + j].getCard().hasDifferentColor(grid[x][y].getCard()))) {


                        // Je regarde la position de la case adjacente par rapport à ma case

                    }
                }


            }
        }


    }



    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }


    public String maxOfColors(){

        int countPrincess = 0;

        for (int y = 0; y < 4; y++){
            for (int x = 0; x < 4; x++){
                if (this.grid[x][y].card.getColor().equals("princess")){
                    countPrincess++;
                }
            }
        }

        if (countPrincess > 8){
            return "princess";
        } else if (countPrincess == 8){
            return "equality";
        } else {
            return "zerg";
        }
    }

    public boolean isFull(){
        for (int y = 0; y < 4; y++){
            for (int x = 0; x < 4;){
                if (!this.grid[x][y].isEmpty()){
                    x++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}
