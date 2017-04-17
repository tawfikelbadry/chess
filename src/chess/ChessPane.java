/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.control.Controller;
import static chess.control.Controller.white_player;
import chess.model.TYPES;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 *
 * @author tito
 */
public class ChessPane extends GridPane implements EventHandler<MouseEvent> {

    public static Square squares[][] = new Square[8][8];

    public ChessPane() {

        this.setWidth(800);
        this.setHeight(700);
        this.setStyle("-fx-border-color: #689dc7;\n"
                + "-fx-border-width: 20;\n"
                + "-fx-border-style: solid;\n"
                + "");

        for (int i = 0; i < squares.length; i++) {
            for (int l = 0; l < squares[i].length; l++) {
                if (((i + l) % 2) == 0) {
                    squares[l][i] = new Square("#FFF", this);
                    this.add(squares[l][i], l, i);
                } else {
                    squares[l][i] = new Square("#62a5e0", this);
                    this.add(squares[l][i], l, i);

                }

                squares[l][i].setOnMouseClicked(this);

            }
        }

        Controller.initializeGame();

    }

    //----------------------------------------------------------------------///
    Pair<String, Integer> current_type;
    boolean isReady = false;

    ArrayList<Pair<Integer, Integer>> availableSquares = new ArrayList();

    Image chhosed_img = null;
    Square choosed_sr = null;

    private boolean isFirstPlayer = true;

    private int fromRow, fromCol, toRow, toCol;

    @Override
    public void handle(MouseEvent event) {
        Square temp = (Square) event.getSource();

        //    if (isFirstPlayer) {
        if (isReady == false) {
            availableSquares.clear();
            // get selected row and column 
            Pair<Integer, Integer> selectedPoint = Controller.getClickedSquareLocation(temp);
            fromRow = selectedPoint.getValue();
            fromCol = selectedPoint.getKey();

            if (temp.getSquareImage() != null) {

                // check if the piece is for white player 
                int l = 0;

                for (l = 0; l < Controller.white_player.getPieces().size(); l++) {
                    if (fromRow == Controller.white_player.getPieces().get(l).getRow()
                            && fromCol == Controller.white_player.getPieces().get(l).getColumn()) {
                        System.out.println("white player");

                        /// if it is white Pawn 
                        if (Controller.white_player.getPieces().get(l).getPiece_type() == TYPES.PAWN) {

                            current_type = TYPES.PAWN;
                            if (Controller.white_player.getPieces().get(l).isFirstMove()) {
                                for (int o = 1; o <= 2; o++) {
                                    if (squares[fromCol][fromRow - o].getSquareImage() != null || fromRow - o < 0) {
                                        break;
                                    }
                                    squares[fromCol][fromRow - o].setDotOnSquare();
                                    availableSquares.add(new Pair(fromCol, fromRow - o));
                                    Controller.white_player.getPieces().get(l).setFirstMove(false);

                                }

                            } else {
                                for (int o = 1; o <= 1; o++) {
                                    if (squares[fromCol][fromRow - o].getSquareImage() != null || fromRow - o < 0) {
                                        break;
                                    }
                                    squares[fromCol][fromRow - o].setDotOnSquare();
                                    availableSquares.add(new Pair(fromCol, fromRow - o));

                                }

                            }

                        }
                        break;

                    }

                }

                choosed_sr = temp;
                chhosed_img = temp.getSquareImage();
                choosed_sr.setSelectedSquareStyle();
                isReady = true;
            }
        } else {

            if (current_type == TYPES.PAWN) {

                System.out.println("*** " + fromCol + " " + fromRow);
                availableSquares.add(new Pair<>(fromCol + 1, fromRow - 1));
                availableSquares.add(new Pair<>(fromCol - 1, fromRow - 1));

                for (int o = 0; o < availableSquares.size(); o++) {

                    System.out.println("----" + availableSquares.get(o).getKey() + " " + availableSquares.get(o).getValue());
                }
                
                 // get selected row and column 
                    Pair<Integer, Integer> selectedPoint2 = Controller.getClickedSquareLocation(temp);
                    toRow = selectedPoint2.getValue();
                    toCol = selectedPoint2.getKey();
                    System.out.println(toRow + "  " + toCol);

                if (temp.getSquareImage() == null || white_player.getPieceIndex(toRow, toCol) == 0) {
                                       if (isAvailable(toRow, toCol)) {
                        choosed_sr.removeImage();

                        int pieceId = Controller.white_player.getPieceIndex(fromRow, fromCol);
                        Controller.white_player.getPieces().get(pieceId).setColumn(toCol);
                        Controller.white_player.getPieces().get(pieceId).setRow(toRow);
                        temp.setSquareImage(chhosed_img);

                    }
                    isReady = false;
                    choosed_sr.setDefaultSqaureStyle();
                    clearSquaresDots();
                }
            }

            isFirstPlayer = false;
        }
        System.out.println(temp.getSquareImage());
//        } else {
//            if (isReady == false) {
//                if (temp.getSquareImage() != null) {
//                    choosed_sr = temp;
//                    chhosed_img = temp.getSquareImage();
//                    choosed_sr.setSelectedSquareStyle();
//                    isReady = true;
//                }
//            } else {
//                //if (temp.getSquareImage() == null) {
//                choosed_sr.removeImage();
//
//                temp.setSquareImage(chhosed_img);
//                choosed_sr.setDefaultSqaureStyle();
//                //   }
//                isReady = false;
//                isFirstPlayer = true;
//
//            }
//            System.out.println(temp.getSquareImage());
        //      }

    }

    public boolean isAvailable(int row, int col) {
        for (int i = 0; i < availableSquares.size(); i++) {
            if (availableSquares.get(i).getKey() == col && availableSquares.get(i).getValue() == row) {
                return true;
            }
        }
        return false;
    }

    public void clearSquaresDots() {
        for (int i = 0; i < squares.length; i++) {
            for (int l = 0; l < squares[i].length; l++) {
                squares[l][i].clearDotSquare();
            }

        }

    }

}
