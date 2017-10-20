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
public class ClienteMulticast {
    
    public String receber(){
        String data;
        while(true) {
            try {                
                MulticastSocket mcs = new MulticastSocket(5000);
                InetAddress grp = InetAddress.getByName("224.2.2.1");
                mcs.joinGroup(grp);
                byte rec[] = new byte[256];
                DatagramPacket pkg = new DatagramPacket(rec, rec.length);
                mcs.receive(pkg);
                data = new String(pkg.getData());
                return data;
            }
            catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
            }   
                        
        }
        
    }
        
}
