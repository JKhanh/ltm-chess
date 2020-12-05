/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.Message;
import model.User;

/**
 *
 * @author khanh
 */
public class ClientController {
    private Socket mSocket;
    private String host = "localhost";
    private int serverPort = 1080;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientController() {
    }
    
    public Socket openConnection(){
        try {
            mSocket = new Socket(host, serverPort);
            oos = new ObjectOutputStream(mSocket.getOutputStream());
            ois = new ObjectInputStream(mSocket.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return mSocket;
    }
    
    public void sendData(Message message) {
        try {
            oos.writeObject(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Object recieveData(){
        try{
            Object data = ois.readObject();
            if(data instanceof Message){
                Message message = (Message) data;
                switch (message.getType()){
                    case LOGIN:
                        if(message.getObject() instanceof User){
                            User user = (User)message.getObject();
                            System.out.println("LOGIN");
                            return user.getUserType() == User.UserType.PLAYER;
                        } else return (Boolean) message.getObject();
                    case GETFRIEND:
                        if(message.getObject() instanceof ArrayList){
                            System.out.println("Get some friend");
                            return (ArrayList<String>)message.getObject();
                        }
                    case CHALLENGE:
                        if(message.getObject() instanceof String){
                            System.out.println("Controller Challege");
                            return (String) message.getObject();
                        }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public void closeConnection() {
        try {
            oos.close();
            ois.close();
            mSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
