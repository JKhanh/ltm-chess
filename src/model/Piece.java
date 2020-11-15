/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author khanh
 */
public class Piece implements Serializable {
    private static final long serialVersionUID = 6529685098267757693L;
    
    private ColorType color;
    private PieceType type;
    private int column;
    private int row;

    public Piece(ColorType color, PieceType type, int column, int row) {
        this.color = color;
        this.type = type;
        this.column = column;
        this.row = row;
    }
    
    public enum ColorType{
        WHITE, BLACK
    }
    
    public enum PieceType{
        KING, QUEEN, ROOK, KNIGHT, BISHOP, PAWN
    }
    
}
