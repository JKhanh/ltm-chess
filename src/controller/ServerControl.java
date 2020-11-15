/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.Message;
import model.Message.MessageType;
import model.User;

/**
 *
 * @author khanh
 */
public class ServerControl implements Runnable{
    private Socket client;
    private UserDao userDao = new UserDao();
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ServerControl(Socket client) {
        this.client = client;
        try{
            ois = new ObjectInputStream(client.getInputStream());
            oos = new ObjectOutputStream(client.getOutputStream());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
                Object o = ois.readObject();
                if(o instanceof Message){
                    Message request = (Message) o;
                    Message response = new Message();
                    if(request.getType() == MessageType.LOGIN){
                        Object obj = request.getObject();
                        if(obj instanceof User){
                            User user = (User) obj;
                            boolean result = userDao.login(user);
                            response = new Message(result, MessageType.LOGIN);
                        } 
                    }
                    oos.writeObject(response);
                }
                        
                Thread.sleep(100);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            try{
                ois.close();
                oos.close();
                client.close();
            }catch(Exception ex1){
                ex1.printStackTrace();
            }  
        }

    }
}
