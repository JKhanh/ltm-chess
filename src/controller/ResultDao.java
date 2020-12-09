/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.Game;

/**
 *
 * @author khanh
 */
public class ResultDao extends Dao {
    private UserDao userDao = new UserDao();

    public ResultDao() {
        super();
    }
    
    public void addResult(Game game){
        String query = "INSERT INTO result(player1, player2, player1_win) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, game.getWhitePlayer());
            ps.setInt(2, game.getBlackPlayer());
            ps.setBoolean(3, game.isIsWhiteWin());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
