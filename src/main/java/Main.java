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
        int totalMines = 5;

        /*TO DO
        *When selecting a square
        * if its a bomb - game over
        * if not a bomb - display number of bombs
        * */

        Board myBoard = new Board(x, y, totalMines);

        //while game not over run the loop
        while (!myBoard.getGameOver() && !myBoard.getGameWon()){
            myBoard.buildBoard();
            int[] guess = new int[2];
            System.out.println("Please enter a x value");
            guess[0] = myScanner.nextInt() - 1 ;
            System.out.println("Please enter a y value");
            guess[1] = myScanner.nextInt() - 1 ;

            myBoard.selectTile(guess[0], guess[1]);

            if( myBoard.getHasMine(guess[0], guess[1]) ){
                myBoard.setGameOver();
            }
        }

        if( myBoard.getGameWon() ) {
            System.out.println("Congratulations you won the game!");
        } else{
            //insert logic to display all bombs
            //myBoard.setAllMines();
            myBoard.buildBoard();
            System.out.println("Better luck next time :(");
        }

    }
}
