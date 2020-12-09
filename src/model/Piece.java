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

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    } 
}
