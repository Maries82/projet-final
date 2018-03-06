package io.pax.starstone.domain;

public class Grid {

    public final static int NBR_CASES_COTE = 4;
    public Cell[][] grid;

    public Grid(Cell[][] grid) {
        this.grid = grid;
    }


    //
    public void insertCard(int x, int y, Card card) {

        // placement de la carte dans la grille
        this.grid[x][y].setCard(card);
        Cell currentCell = this.grid[x][y];

        // recherche des cases adjacentes à la case séléctionnée
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                Cell adjacentCell = this.grid[x+i][y+j];

                // gestion des cases hors tableau
                if (x + i > 4 ||  x + i < 0 ||  y + j > 4 || y + j < 0 || (i!=0 && j != 0) ||( i==0 && j==0)) {
                    System.out.println("la case est hors tableau");
                }

                // je vérifie que la case adjacente possède une carte
                else if (!(adjacentCell.isEmpty())) {

                    // je regarde si la carte adjacente est de couleur differente
                    if (adjacentCell.getCard().hasDifferentColor(currentCell.getCard())) {


                        // Je regarde la position de la case adjacente par rapport à ma case
                        int pos = currentCell.returnAdjacentCellPosition(adjacentCell);

                        // Si la case est au dessus
                        if (pos == 0 ){
                            if (currentCell.getCard().getUp() > adjacentCell.getCard().getDown()){
                                this.grid[x+i][x+j].getCard().setColor(currentCell.getCard().getColor());
                                System.out.println(adjacentCell.getCard().toString()+"A changé de couleur");
                            }
                        }
                        // Si la case est à droite
                        if (pos == 1 ){
                            if (currentCell.getCard().getRight() > adjacentCell.getCard().getLeft()){
                                this.grid[x+i][x+j].getCard().setColor(currentCell.getCard().getColor());
                            }
                        }
                        // Si la case est en dessous
                        if (pos == 2 ){
                            if (currentCell.getCard().getDown() > adjacentCell.getCard().getUp()){
                                this.grid[x+i][x+j].getCard().setColor(currentCell.getCard().getColor());
                            }
                        }
                        // Si la case est à gauche
                        if (pos == 3 ){
                            if (currentCell.getCard().getLeft() > adjacentCell.getCard().getRight()){
                                this.grid[x+i][x+j].getCard().setColor(currentCell.getCard().getColor());
                            }
                        }
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

    @Override
    public String toString() {
        return super.toString();
    }
}
