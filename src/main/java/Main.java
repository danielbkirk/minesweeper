import oop.blueprints.Board;
//import oop.blueprints.Tile;

import java.util.Scanner;
//import java.util.Random;

public class Main {

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper, are you ready to play!");
        System.out.println("How wide would you like your board to be?");
        int x = myScanner.nextInt();
        System.out.println("How high would you like your board to be?");
        int y = myScanner.nextInt();
        int totalMines = (int) Math.ceil((x * y) / 5.0);

        /*TO DO
        * When board size goes > 10 in x, numbers don't line up properly -
        * If tile already selected make it so you cant select it again
        * when selecting a tile with bomb count 0 reveal all surrounding tiles.
        * */

        Board myBoard = new Board(x, y, totalMines);

        //while game not over run the loop
        while (!myBoard.getGameOver() && !myBoard.getGameWon()){
            myBoard.buildBoard();
            System.out.println(myBoard.getEmptyTiles());
            System.out.println("Type 1 to reveal a tile or type 2 to toggle a flag");
            int clickType = myScanner.nextInt();
            if ( clickType == 1 ||  clickType == 2  ) {
                int[] guess = new int[2];
                System.out.println("Please enter a x value");
                guess[0] = myScanner.nextInt() - 1;
                System.out.println("Please enter a y value");
                guess[1] = myScanner.nextInt() - 1;
                if (clickType == 1) {
                    myBoard.selectTile(guess[0], guess[1]);
                    if (myBoard.getHasMine(guess[0], guess[1])) {
                        myBoard.setGameOver();
                    } else if (myBoard.getEmptyTiles() == 0) {
                        System.out.println("Test to see if the code reaches this part");
                        myBoard.setGameWon();
                    }
                }
                if (clickType == 2) {
                    myBoard.setFlag(guess[0], guess[1]);
                }
            } else{
                System.out.println("Please select a valid option");
            }
        }

        myBoard.displayAllMines();
        myBoard.buildBoard();

        if( myBoard.getGameWon() ) {
            System.out.println("Congratulations you won the game!");
        } else{

            System.out.println("Better luck next time :(");
        }

    }
}
