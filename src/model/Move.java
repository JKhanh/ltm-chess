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
public class Move implements Serializable{
    private static final long serialVersionUID = 6529685098267757697L;
    
    private Piece piece;
    private int row;
    private int column;

    public Move() {
    }

    public Move(Piece piece, int row, int column) {
        this.piece = piece;
        this.row = row;
        this.column = column;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
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
    
    public void move(){
        piece.setRow(row);
        piece.setColumn(column);
    }
    
}
