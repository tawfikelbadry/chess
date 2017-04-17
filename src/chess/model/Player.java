package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private boolean black;

    private int PAWNS = 8;
    private int BISHOPS = 2;
    private int ROOKS = 2;
    private int KNIGHTS = 2;
    private int QUEEN = 1;
    private List<Piece> pieces = new ArrayList();

    public Player(boolean black) {
        this.black = black;
        this.PAWNS = 8;
        this.BISHOPS = 2;
        this.ROOKS = 2;
        this.KNIGHTS = 2;
        this.QUEEN = 1;
        pieces.clear();

    }

    public int getPAWNS() {
        return PAWNS;
    }

    public void setPAWNS(int aPAWNS) {
        PAWNS = aPAWNS;
    }

    public int getBISHOPS() {
        return BISHOPS;
    }

    public void setBISHOPS(int aBISHOPS) {
        BISHOPS = aBISHOPS;
    }

    public int getROOKS() {
        return ROOKS;
    }

    public void setROOKS(int aROOKS) {
        ROOKS = aROOKS;
    }

    public int getKNIGHTS() {
        return KNIGHTS;
    }

    public void setKNIGHTS(int aKNIGHTS) {
        KNIGHTS = aKNIGHTS;
    }

    public int getQUEEN() {
        return QUEEN;
    }

    public void setQUEEN(int aQUEEN) {
        QUEEN = aQUEEN;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public int getPieceIndex(int row, int col) {
        for (int i = 0; i < this.pieces.size(); i++) {
            if (pieces.get(i).getRow() == row && pieces.get(i).getColumn() == col) {
                return i;
            }
        }
        return 0;
    }

}
