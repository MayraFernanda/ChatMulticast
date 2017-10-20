/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u14189
 */

public class Chat {
    public static void main(String[] args){
        
        ServidorMulticast servidor = new ServidorMulticast();
        ClienteMulticast cliente = new ClienteMulticast();
   
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        new Thread(){
            @Override
            public void run(){                
                try {
                    String msg = reader.readLine();
                    servidor.enviar(msg);
                } catch (IOException ex) {
                    Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                }      
            }
        }.start();
        
        while(true){
            System.out.println(cliente.receber());
        }
        
    }
}
