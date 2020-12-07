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
import java.util.ArrayList;
import model.Board;
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
    private User user = new User();
    private ServerControl opSc;
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
                    Object obj = request.getObject();
                    switch(request.getType()){
                        case LOGIN:
                            System.out.println("Login");
                            if(obj instanceof User){
                                User mUser = (User) obj;
                                Boolean result = userDao.login(mUser);
                                user = mUser;
                                if(result) response = new Message(user, MessageType.LOGIN);
                                else response = new Message(result, MessageType.LOGIN);
                                System.out.println(response.getType());
                                oos.writeObject(response);  
                            } 
                            break;
                        case CHALLENGE:
                            System.out.println("Challenge");
                            if(obj instanceof String){
                                String opName = (String) obj;
                                for(ServerControl sc: ServerThread.clients){
                                    if(opName.equals(sc.user.getUsername())){
                                        opSc = sc;
                                        try{
                                            ObjectOutputStream objos = opSc.oos;
                                            Message m = new Message(user.getUsername(), MessageType.CHALLENGE);
                                            objos.writeObject(m);
                                        }catch(Exception ex){
                                            ex.printStackTrace();
                                        }
                                    }
                                }
                            } else if(obj instanceof Boolean){
                                Boolean accept = (Boolean) obj;
                                response = new Message(accept, MessageType.CHALLENGE);
                                System.out.println(response.getType());
                                oos.writeObject(response);
                            }
                            break;
                        case LOADGAME:
                            Board board = new Board(user.getUsername(), opSc.user.getUsername());
                            response = new Message(board, MessageType.LOADGAME);
                            break;
                        case GETFRIEND:
                            System.out.println("GET Friend");
                            ArrayList<String> players = userDao.listPlayer();
                            for(String s: players){
                                System.out.println(s);
                            }
                            players.remove(user.getUsername());
                            response = new Message(players, MessageType.GETFRIEND);
                            System.out.println(response.getType());
                            oos.writeObject(response);
                            break;
                    }
                    
                }
                Thread.sleep(100);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            try{
                ois.close();
                oos.close();
                client.close();
                userDao.updateStatus(user, User.UserStatus.OFFLINE);
            }catch(Exception ex1){
                ex1.printStackTrace();
            }  
        }

    }
}
