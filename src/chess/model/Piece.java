
package chess.model;

import javafx.util.Pair;

/**
 *
 * @author tito
 */

public class Piece {
    
    
    private Pair<String,Integer> piece_type;
    private boolean exist;
    private int row;
    private int column;
    
    
    // just for PAWN 
    private boolean firstMove=true;

    public Piece() {

    }

    public Piece(Pair<String, Integer> piece_type, boolean exist, int row, int column) {
        this.piece_type = piece_type;
        this.exist = exist;
        this.row = row;
        this.column = column;
    }
    
    
    

    public Piece(boolean exist, int row, int column) {
        this.exist = exist;
        this.row = row;
        this.column = column;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    
    
    public void setLocation(Pair <Integer,Integer>loc){
    this.row=loc.getKey();
    this.column=loc.getValue();
    
    }
    
    
    
    public Pair getLocation() {

        Pair<Integer, Integer> loc = new Pair<>(row, column);

        return loc;
    }

    public Pair<String,Integer> getPiece_type() {
        return piece_type;
    }

    public void setPiece_type(Pair<String,Integer> piece_type) {
        this.piece_type = piece_type;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

   

}
