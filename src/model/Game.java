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
    
    private String whitePlayer;
    private String blackPlayer;
    private boolean isWhiteWin;

    public Game() {
        
    }

    public Game(String whitePlayer, String blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
    }
    
    public String getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(String whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public String getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(String blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public boolean isIsWhiteWin() {
        return isWhiteWin;
    }

    public void setIsWhiteWin(boolean isWhiteWin) {
        this.isWhiteWin = isWhiteWin;
    }
    
}
