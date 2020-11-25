/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;
import model.User.UserStatus;
import model.User.UserType;

/**
 *
 * @author khanh
 */
public class UserDao extends Dao{

    public UserDao() {
        super();
    }
    
    public Boolean login(User user){
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUserType(UserType.valueOf(rs.getString("user_type")));
                UserStatus status = UserStatus.valueOf(rs.getString("status"));
                if(status == UserStatus.OFFLINE){
                    updateStatus(user, UserStatus.ONLINE);
                    user.setStatus(UserStatus.ONLINE);
                }
                return true;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public void updateStatus(User user, UserStatus status){
        String query = "UPDATE users SET status = ? WHERE id = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status.toString());
            ps.setInt(2, user.getId());
            ps.executeUpdate();
            user.setStatus(status);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public ArrayList<String> listPlayer(){
        ArrayList<String> players = new ArrayList<>();
        String query = "SELECT username FROM users WHERE status = 'ONLINE'";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                players.add(rs.getString("username"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return players;
    }
    
}
