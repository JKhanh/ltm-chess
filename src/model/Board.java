/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class Board implements Serializable {
    private static final long serialVersionUID = 6529685098267757692L;
    
    private ArrayList<Piece> pieces = new ArrayList();
    
    public Board() {
        generatePiece(Piece.ColorType.WHITE);
        generatePiece(Piece.ColorType.BLACK);
    }
    
    private void generatePiece(Piece.ColorType color){
        int column;
        char row;
        if(color == Piece.ColorType.WHITE){
            column = 1;
            row = 1;
        }
        else {
            column = 8;
            row = 8;
        }
        pieces.add(new Piece(color, Piece.PieceType.KING, column, row+3));
        pieces.add(new Piece(color, Piece.PieceType.QUEEN, column, row+4));
        
        pieces.add(new Piece(color, Piece.PieceType.BISHOP, column, row+2));
        pieces.add(new Piece(color, Piece.PieceType.KNIGHT, column, row+1));
        pieces.add(new Piece(color, Piece.PieceType.ROOK, column, row));
        
        pieces.add(new Piece(color, Piece.PieceType.BISHOP, column, row+5));
        pieces.add(new Piece(color, Piece.PieceType.KNIGHT, column, row+6));
        pieces.add(new Piece(color, Piece.PieceType.ROOK, column, row+7));
        
        for (int i = 0; i < 8; i++) {
            pieces.add(new Piece(color, Piece.PieceType.PAWN, column, row+i));
        }
    }
    
}
