/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.control;

import static chess.ChessPane.squares;
import chess.Square;
import chess.model.PIECES_IMAGES;
import chess.model.Piece;
import chess.model.Player;
import chess.model.TYPES;
import javafx.util.Pair;

/**
 *
 * @author tito
 */
public class Controller {

    public static Player white_player = new Player(false);
    public static Player black_player = new Player(true);

    public static void initializeGame() {
        // take care of that
        // squares[col][row]
        //Piece(TYPES.PAWN, true, row, col)

        // to inilize player
        white_player = new Player(false);
        black_player = new Player(true);

        //  setting initializing white icons 
        // white pawns
        for (int i = 0; i < 8; i++) {

            white_player.getPieces().add(new Piece(TYPES.PAWN, true, 6, i));
            squares[i][6].setSquareImage(PIECES_IMAGES.WHITE_BAWN);
        }
        /*-----------------------------------------------------------------*/
        // white horses
        white_player.getPieces().add(new Piece(TYPES.KNIGHT, true, 7, 1));
        white_player.getPieces().add(new Piece(TYPES.KNIGHT, true, 7, 6));

        squares[1][7].setSquareImage(PIECES_IMAGES.WHITE_KNIGHT);
        squares[6][7].setSquareImage(PIECES_IMAGES.WHITE_KNIGHT);
        /*-----------------------------------------------------------------*/

        // white elephants
        white_player.getPieces().add(new Piece(TYPES.BISHOP, true, 7, 2));
        white_player.getPieces().add(new Piece(TYPES.BISHOP, true, 7, 5));

        squares[2][7].setSquareImage(PIECES_IMAGES.WHITE_BISHOP);
        squares[5][7].setSquareImage(PIECES_IMAGES.WHITE_BISHOP);
        /*-----------------------------------------------------------------*/
        // white tabya 
        white_player.getPieces().add(new Piece(TYPES.ROOK, true, 7, 0));
        white_player.getPieces().add(new Piece(TYPES.ROOK, true, 7, 7));

        squares[0][7].setSquareImage(PIECES_IMAGES.WHITE_ROOK);
        squares[7][7].setSquareImage(PIECES_IMAGES.WHITE_ROOK);
        /*-----------------------------------------------------------------*/

        // white wazeer and king
        white_player.getPieces().add(new Piece(TYPES.QWEEN, true, 7, 3));
        white_player.getPieces().add(new Piece(TYPES.KING, true, 7, 4));

        squares[3][7].setSquareImage(PIECES_IMAGES.WHITE_QUEEN);
        squares[4][7].setSquareImage(PIECES_IMAGES.WHITE_KING);
        /*-----------------------------------------------------------------*/

        //  setting initializing black icons 
        // black soldiers
        for (int i = 0; i < 8; i++) {
            black_player.getPieces().add(new Piece(TYPES.PAWN, true, 1, i));

            squares[i][1].setSquareImage(PIECES_IMAGES.BLACK_BAWN);
        }
        /*-----------------------------------------------------------------*/

        // black horses
        black_player.getPieces().add(new Piece(TYPES.KNIGHT, true, 0, 1));
        black_player.getPieces().add(new Piece(TYPES.KNIGHT, true, 0, 6));

        squares[1][0].setSquareImage(PIECES_IMAGES.BLACK_KNIGHT);
        squares[6][0].setSquareImage(PIECES_IMAGES.BLACK_KNIGHT);
        /*-----------------------------------------------------------------*/

        // black elephants
        black_player.getPieces().add(new Piece(TYPES.BISHOP, true, 0, 2));
        black_player.getPieces().add(new Piece(TYPES.BISHOP, true, 0, 5));

        squares[2][0].setSquareImage(PIECES_IMAGES.BLACK_BISHOP);
        squares[5][0].setSquareImage(PIECES_IMAGES.BLACK_BISHOP);
        /*-----------------------------------------------------------------*/

        // black tabya 
        black_player.getPieces().add(new Piece(TYPES.ROOK, true, 0, 0));
        black_player.getPieces().add(new Piece(TYPES.ROOK, true, 0, 7));

        squares[0][0].setSquareImage(PIECES_IMAGES.BLACK_ROOK);
        squares[7][0].setSquareImage(PIECES_IMAGES.BLACK_ROOK);
        /*-----------------------------------------------------------------*/

        // black wazeer and king
        black_player.getPieces().add(new Piece(TYPES.QWEEN, true, 0, 3));
        black_player.getPieces().add(new Piece(TYPES.KING, true, 0, 4));

        squares[3][0].setSquareImage(PIECES_IMAGES.BLACK_QUEEN);
        squares[4][0].setSquareImage(PIECES_IMAGES.BLACK_KING);

    }

    public static void clearGame() {
        for (int i = 0; i < squares.length; i++) {
            for (int l = 0; l < squares[i].length; l++) {
                squares[l][i].removeImage();
            }
        }

    }

    public static Pair<Integer, Integer> getClickedSquareLocation(Square sq) {
        for (int i = 0; i < squares.length; i++) {
            for (int l = 0; l < squares[i].length; l++) {
                if (sq == squares[i][l]) {
                    System.out.println(l + "  " + i);
                    return new Pair<>(i, l);

                }
            }
        }
        return null;
    }

}
