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
public class Game implements Serializable{
    
    private int whitePlayer;
    private int blackPlayer;
    private boolean isWhiteWin;

    public Game() {
        
    }

    public Game(int whitePlayer, int blackPlayer, boolean isWhiteWin) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.isWhiteWin = isWhiteWin;
    }

    public int getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(int whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public int getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(int blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public boolean isIsWhiteWin() {
        return isWhiteWin;
    }

    public void setIsWhiteWin(boolean isWhiteWin) {
        this.isWhiteWin = isWhiteWin;
    }
    
}
