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
        Cell currentCell = this.grid[x][y];

        // recherche des cases adjacentes à la case séléctionnée
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {



                // gestion des cases hors tableau
                if (x + i >= NBR_CASES_COTE || x + i < 0 || y + j >= NBR_CASES_COTE || y + j < 0)
                    continue;

                Cell adjacentCell = this.grid[x + i][y + j];

                // gestion des cases diagonales et identiques à currentCell
                if ((i != 0 && j != 0) || (i == 0 && j == 0))
                    continue;

                // je vérifie que la case adjacente possède une carte
                if (adjacentCell.isEmpty())
                    continue;

                //Je vérifie que la carte de la cellule adjacente soit de couleur différente
                if (currentCell.cardHasSameColor(adjacentCell))
                    continue;


                // Je regarde la position de la case adjacente par rapport à ma case
                int pos = currentCell.returnAdjacentCellPosition(adjacentCell);

                // Si la adjacente case est au dessus
                if (pos == 0) {
                    if (currentCell.getCard().getUp() > adjacentCell.getCard().getDown()) {
                        this.grid[x + i][x + j].getCard().setColor(currentCell.getCard().getColor());

                    }
                }
                // Si la case adjacente est à droite
                if (pos == 1) {
                    if (currentCell.getCard().getRight() > adjacentCell.getCard().getLeft()) {
                        this.grid[x + i][x + j].getCard().setColor(currentCell.getCard().getColor());
                    }
                }
                // Si la case adjacente est en dessous
                if (pos == 2) {
                    if (currentCell.getCard().getDown() > adjacentCell.getCard().getUp()) {
                        this.grid[x + i][x + j].getCard().setColor(currentCell.getCard().getColor());
                    }
                }
                // Si la case adjacente est à gauche
                if (pos == 3) {
                    if (currentCell.getCard().getLeft() > adjacentCell.getCard().getRight()) {
                        this.grid[x + i][x + j].getCard().setColor(currentCell.getCard().getColor());
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




