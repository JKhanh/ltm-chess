/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author khanh
 */
public class ServerThread implements Runnable{
    private ServerSocket server;
    private int port = 1080;
    Socket client;

    public ServerThread() {
    }

    @Override
    public void run() {
        while (true) {            
            try{
                server = new ServerSocket(port);
                while(!Thread.currentThread().isInterrupted()){
                    client = server.accept();
                    ServerControl sc = new ServerControl(client);
                    new Thread(sc).start();
                }
                
                Thread.sleep(100);
                client.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }  
        }
        
    }
    
}
