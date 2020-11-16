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
public class User implements Serializable {
    private static final long serialVersionUID = 6529685098267757691L;
    
    private int id;
    private String username;
    private String password;
    private UserType userType;
    private UserStatus status;

    public User(String username, String password, UserType userType, UserStatus status) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.status = status;
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
    
    public enum UserType{
        PLAYER, ADMIN
    }
    
    public enum UserStatus{
        OFFLINE, ONLINE, BUSY
    }
}
