/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.piece.Piece;
import java.io.Serializable;

/**
 *
 * @author khanh
 */
public class Move implements Serializable{
    private static final long serialVersionUID = 6529685098267757697L;
    
    private Piece piece;
    private Piece capturedPiece;
    private char originFile;
    private int originRank;
    private char destinationFile;
    private int destinationRank;
    private boolean valid;
    private int timeUsed;

    public Move(Piece piece, Piece capturedPiece, char originFile, int originRank, char destinationFile, int destinationRank) {
        this.piece = piece;
        this.capturedPiece = capturedPiece;
        this.originFile = originFile;
        this.originRank = originRank;
        this.destinationFile = destinationFile;
        this.destinationRank = destinationRank;
        this.valid = false;
    }

    public Piece getPiece() {
        return piece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public char getOriginFile() {
        return originFile;
    }

    public int getOriginRank() {
        return originRank;
    }

    public char getDestinationFile() {
        return destinationFile;
    }

    public int getDestinationRank() {
        return destinationRank;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public int getTimeUsed() {
        return timeUsed;
    }
}
