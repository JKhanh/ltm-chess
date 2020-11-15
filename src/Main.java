
import controller.ServerThread;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khanh
 */
public class Main {
    
    public static void main(String[] args) {
        Thread thread = new Thread(new ServerThread());
        thread.start();
    }
    
}
