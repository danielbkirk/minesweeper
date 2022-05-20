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

    public boolean getMine(){
        return this.hasMine;
    }
    public void setMine(){ this.hasMine = true;}

    public void setMinesAround(){this.minesAround++;}
    public int getMinesAround(){return this.minesAround;}

    public void setFlag(){
        if(this.flag){
            this.flag = false;
        } else{
            this.flag = true;
        }
    }

    public boolean getFlag(){
        return this.flag;
    }
}
