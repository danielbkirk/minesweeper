import oop.blueprints.Board;
//import oop.blueprints.Tile;

import java.util.Scanner;
//import java.util.Random;

public class Main {

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper, are you ready to play!");
        System.out.println("We will be testing a 4x4 grid");
        int x = 4;
        int y = 4;
        int totalMines = 5;

        /*TO DO
        *When selecting a square
        * if its a bomb - game over
        * if not a bomb - display number of bombs
        * */

        Board myBoard = new Board(x, y, totalMines);

        //while game not over run the loop
        while (!myBoard.getGameOver() && !myBoard.getGameWon()){
            int[] guess = new int[2];
            System.out.println("Please enter a x value");
            guess[0] = myScanner.nextInt();
            System.out.println("Please enter a y value");
            guess[1] = myScanner.nextInt();
            if( myBoard.getHasMine(guess[0], guess[1]) ){
                myBoard.setGameOver();
            } else{

            }

        }
        System.out.println("Game Over");
    }
}
