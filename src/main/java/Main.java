import oop.blueprints.Board;
import oop.blueprints.Tile;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper, are you ready to play!");
        System.out.println("We will be testing a 4x4 grid");
        int x = 4;
        int y = 4;
        int totalMines = 10;
        int minesAssigned = 0;
        /*TO DO
        * assign mines to tiles - have in if mine already assigned skip past tile
        * Build the board, change to battleship style numbering(on outisde rather than number each tile)
        * Once all the mines have been given out, find number of mines surrounding tile
        *
        * */
        Board myBoard = new Board(x, y, totalMines);


        //Assigning mines - created a function before main class


        //printing out grid
        for (int i = 0; i < x; i++) {
            String row = "";
            for (int j = 0; j < y; j++) {
                row = row + i + "," + j + " | ";
            }
            System.out.println(row);
        }

        int[] guess = new int[2];
        System.out.println("Please enter a x value");
        guess[0] = myScanner.nextInt();
        System.out.println("Please enter a y value");
        guess[1] = myScanner.nextInt();
        System.out.println("Your guess was " + guess[0] + ", " + guess[1]);


    }
}
