package io.pax.starstone.domain;

public class Grid {

    public final static int NBR_CASES_COTE = 4;
    public Cell[][] grid;

    public Grid() {
        this.grid = initializeGrid();
    }


    //
    public void insertCard(int x, int y, Card card) {

        // placement de la carte dans la grille
        this.grid[x][y].setCard(card);
        System.out.println("Carte inserrée dans la case : "+this.grid[x][y]);
        Cell currentCell = this.grid[x][y];

        // recherche des cases adjacentes à la case séléctionnée
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {



                // gestion des cases hors tableau
                if (x + i >= NBR_CASES_COTE || x + i < 0 || y + j >= NBR_CASES_COTE || y + j < 0){
                    System.out.println("out of grid");
                    continue;
                }


                Cell adjacentCell = this.grid[x + i][y + j];

                // gestion des cases diagonales et identiques à currentCell
                if ((i != 0 && j != 0) || (i == 0 && j == 0)){
                    System.out.println("diagonal");
                    continue;
                }


                // je vérifie que la case adjacente possède une carte
                if (this.grid[x + i][y + j].isEmpty()){
                    System.out.println("empty");
                    continue;
                }


                //Je vérifie que la carte de la cellule adjacente soit de couleur différente
                if (this.grid[x][y].cardHasSameColor(this.grid[x + i][y + j])){
                    System.out.println("sameColor");
                    continue;
                }



                // Je regarde la position de la case adjacente par rapport à ma case
                /*int pos = this.grid[x][y].returnAdjacentCellPosition(this.grid[x + i][y + j]);
                System.out.println("pos ="+pos);*/

                // Si la adjacente case est au dessus
                if (y+j > y) {
                    if (this.grid[x][y].getCard().getUp() > this.grid[x + i][y + j].getCard().getDown()) {
                        System.out.println("change carte au dessus");
                        System.out.println("Case de dessus à changer : "+this.grid[x + i][y + j].toString());
                        this.grid[x + i][x + j].getCard().setColor(this.grid[x][y].getCard().getColor());
                        System.out.println("Case du dessus dechangée : "+this.grid[x + i][x + j].getCard().getColor());
                    }

                }
                // Si la case adjacente est à droite
                if (x+i > x) {
                    if (this.grid[x][y].getCard().getRight() > this.grid[x + i][y + j].getCard().getLeft()) {
                        this.grid[x + i][x + j].getCard().setColor(this.grid[x][y].getCard().getColor());
                    }

                }
                // Si la case adjacente est en dessous
                if (y+j < y) {
                    if (this.grid[x][y].getCard().getDown() > this.grid[x + i][y + j].getCard().getUp()) {
                        this.grid[x + i][x + j].getCard().setColor(this.grid[x][y].getCard().getColor());
                    }

                }
                // Si la case adjacente est à gauche
                if (x+i < x) {
                    if (this.grid[x][y].getCard().getLeft() > this.grid[x + i][y + j].getCard().getRight()) {
                        System.out.println("change carte a gauche");

                        String colorCurrent = this.grid[x][y]
                                .getCard()
                                .getColor();

                        System.out.println("Case courante"+this.grid[x][y]);

                        if (this.grid[x+i][y+j].isEmpty()){

                            System.out.println("case à changer "+this.grid[x+i][y+j].toString()+" vide");
                        }
                        else if(this.grid[x+i][y+j].getCard().isEmpty()){
                            System.out.println("couleur adjacente vide");
                        }
                        String colorAdjacent = this.grid[x + i][y + j].getCard().getColor();

                        System.out.println("Case à changer: "+this.grid[x + i][y + j].toString());

                        this.grid[x + i][y + j]
                                .card
                                .setColor(colorCurrent);

                        System.out.println("Case changée : "+this.grid[x + i][y + j].toString());
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
        String gridString = "Grid { \n";
        for (int j = 3; j > -1; j--) {
            for (int i = 0; i < 4; i++) {

                gridString += ""+this.grid[i][j].toString()+"\n";
            }

        }
        gridString += " }";
        return gridString;
    }




    public  Cell[][] initializeGrid(){
        Cell[][] grid = new Cell[NBR_CASES_COTE][NBR_CASES_COTE];
        System.out.println(grid[0][0]);
        for (int i = 0; i < NBR_CASES_COTE ; i++) {
            for (int j = 0; j < NBR_CASES_COTE  ; j++) {
                Cell cell = new Cell(i,j);
                System.out.println(cell);
                grid[i][j] = cell;
                System.out.println(grid[i][j]);
            }

        }
        return grid;
    }



}




