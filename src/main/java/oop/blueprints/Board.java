package oop.blueprints;
import java.util.Random;

public class Board {
    Random rand = new Random();
    //Attributes
    //String difficulty;
    int height;
    int width;
    int noOfMines;
    Tile[][] myBoard;
    int minesAssigned = 0;

    boolean gameOver;
    boolean gameWon;
    int emptyTiles;

    //constructor
    //Needs to calculate the number of surrounding mines.

    public Board(int boardWidth, int boardHeight, int noOfMines){
        this.height = boardHeight;
        this.width = boardWidth;
        this.noOfMines = noOfMines;
        this.gameOver = false;
        this.gameWon = false;
        this.emptyTiles = ( this.height * this.width ) - this.noOfMines;
        myBoard = new Tile[this.height][this.width];
        assignTiles();
        assignMines(this.height, this.width, this.noOfMines);

        for ( int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                calcNoSurroundingMines( i, j);
            }
        }
        System.out.println("Your board has been created, have fun!");

    }

    public boolean getGameOver(){
        return this.gameOver;
    }

    public void setGameOver(){
        this.gameOver = true;
    }

    public boolean getGameWon(){
        return this.gameWon;
    }

    public void setGameWon(){
        this.gameWon = true;
    }

    public void assignTiles(){
        for(int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                this.myBoard[i][j] = new Tile(false);
            }
        }
    }
    //needs height, width, no of mines
    //Randomly assigns mines until quota is filled.
    //Keeps going until all are used up.
    //If it loops won't reassign a mine to a tile that already has one
    public void assignMines(int y, int x, int totalMines) {
        while(this.minesAssigned < totalMines) {
            int randX = rand.nextInt(x);
            int randY = rand.nextInt(y);
            if(! myBoard[randY][randX].getMine() ){
                myBoard[randY][randX].setMine();
                this.minesAssigned++;
            }
        }
    }

    //calculate the number of mines surrounding the tile
    public void calcNoSurroundingMines( int posY, int posX){
        for (int i = posY - 1; i <= posY + 1; i++){
            for (int j = posX - 1; j <= posX + 1; j++){
                if ( !(i  < 0 || j < 0 || i >= this.height || j >= this.width || (i == posY && j == posX) ) ){
                    if (myBoard[i][j].getMine()) {
                        myBoard[posY][posX].setMinesAround();
                    }
                }
            }
        }
    }


    public int getNoOfSurroundingMines(int y, int x){
        return myBoard[y][x].getMinesAround();
    }

    public void buildBoard(){
        String numberRow = "y\\x ";
        for (int i = 1; i <= this.width; i++){
            numberRow = numberRow  + i + "  ";
        }
        System.out.println(numberRow);
        //printing out grid
        for (int j = 0; j < this.height; j++) {
            String row = 1+j + "   ";
            for (int i = 0; i < this.width; i++) {
                row = row +  findDisplayString(i, j) + "  ";
            }
            System.out.println(row);
        }
    }


    public void selectTile(int x, int y){
        setEmptyTiles();
        myBoard[y][x].useTile();

    }
    public boolean getHasMine(int x, int y){
        return myBoard[y][x].getMine();
    }

    //find display string - takes x and y value
    //if it does have a bomb display B and change to game over is true
    //if it has been used but does not have a bomb - display number of surrounding bombs

    public String findDisplayString(int x, int y){
        String returnedString;
        if( ! myBoard[y][x].beenUsed && myBoard[y][x].getFlag()){
            returnedString = "F";
        } else if ( !myBoard[y][x].beenUsed ){
            returnedString = ".";
        } else{
            if ( myBoard[y][x].beenUsed && myBoard[y][x].getMine()){
                returnedString = "B";

            } else{
                returnedString = "" + getNoOfSurroundingMines(y, x) +"";
                if(getNoOfSurroundingMines(y, x) == 0){
                    cascadeTiles(x, y);
                }

            }
        }

        return returnedString;
    }

    public void setFlag(int x, int y){
        myBoard[y][x].setFlag();
    }

    //sets all bombs to show - for end of game
    public void displayAllMines(){
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                if( myBoard[i][j].getMine() ){
                    myBoard[i][j].useTile();
                }
            }
        }
    }

    public void setEmptyTiles(){
        this.emptyTiles = this.emptyTiles - 1;
    }

    public int getEmptyTiles(){
        return this.emptyTiles;
    }
    public void cascadeTiles(int x, int y){
        for (int i = y-1; i <= y+1; i++){
            for ( int j = x-1; j <= x+1; j++){
                if ( !( i  < 0 || j < 0 || i >= this.height || j >= this.width ) ) {
                    if( !myBoard[i][j].beenUsed){
                        selectTile(j, i);
                    }

                }
            }
        }

    }

}
