package oop.blueprints;
import java.util.Random;

public class Board {
    Random rand = new Random();
    //Attributes
    String difficulty;
    int height;
    int width;
    int noOfMines;
    Tile[][] myBoard;
    int minesAssigned;

    //constructor
    /*Later will add variable settings at the start of the game*/
    public Board(int boardHeight, int boardWidth, int noOfMines){
        this.height = boardHeight;
        this.width = boardWidth;
        this.noOfMines = noOfMines;
        this.minesAssigned = 0;
        myBoard = new Tile[this.height][this.width];
        assignMines(this.height, this.width, this.noOfMines, this.minesAssigned);

        System.out.println("Your board has been created, have fun!");

    }
    //needs height, width, no of mines
    public void assignMines(int x, int y, int totalMines, int minesUsed) {
        while(minesUsed < totalMines) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (minesUsed <= totalMines) {
                        if (rand.nextBoolean()) {
                            myBoard[i][j] = new Tile(true);
                            minesUsed++;
                        } else {
                            myBoard[i][j] = new Tile(false);
                        }
                    } else {
                        myBoard[i][j] = new Tile(false);
                    }
                }
            }
        }
    }

}
