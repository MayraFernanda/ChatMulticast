/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticast;
import java.net.*;

/**
 *
 * @author u14189
 */
public class ServidorMulticast {
   
    public void enviar(String msg){
         try {
            byte[] b = msg.getBytes();
            InetAddress addr = InetAddress.getByName("224.2.2.1");
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket pkg = new DatagramPacket(b, b.length, addr, 5000);
            MulticastSocket ms = new MulticastSocket();
            ms.joinGroup(addr);
            ms.send(pkg);
        }
        catch(Exception e) {
        System.out.println("Nao foi possivel enviar a mensagem");
        }
    }
       
    
}
