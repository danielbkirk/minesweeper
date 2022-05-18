package oop.blueprints;

public class Tile {

    //Attributes
    boolean flag;
    boolean hasMine;
    int minesAround;
    boolean beenUsed;

    //contructor
    public Tile(boolean givenMine){
        this.flag = false;
        this.hasMine = givenMine;
        this.minesAround = 0;
        this.beenUsed = false;
    }

    //Methods
    //has mines? number of mines around, add/remove flag, been used
    //

    public void useTile(){
        this.beenUsed = true;
    }

    public boolean assignedMine(){
        return this.hasMine;
    }

//    public boolean useFlag(){
//
//    }
}
