/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class ServerThread{
    public static ArrayList<ServerControl> clients = new ArrayList<>();

    public ServerThread() {
    }

    public static void main(String[] args){
        while (true) {            
            try{
                int port = 1080;
                ServerSocket server = new ServerSocket(port);
                while(!Thread.currentThread().isInterrupted()){
                    Socket client = server.accept();
                    System.out.println(client.getInetAddress());
                    ServerControl sc = new ServerControl(client);
                    clients.add(sc);
                    new Thread(sc).start();
                }
                
                Thread.sleep(100);
            }catch(Exception ex){
                ex.printStackTrace();
            }  
        }
        
    }
    
}
