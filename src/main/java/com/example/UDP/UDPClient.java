package com.example.UDP;

import java.io.IOException;
import java.net.*;
public class UDPClient {

    private int port;
    private InetAddress host; 
    private DatagramSocket socket ;
    public UDPClient(int port ,String host) {

            DatagramSocket socket = null;
            try {
                socket = new DatagramSocket();
                InetAddress address = InetAddress.getByName(host);
                this.host = address;
                this.port=port;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null)
            socket.close();
        }
    }

   public void sendMessage(String message){
       
        byte[] data = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, this.host, this.port);
        try {
            this.socket.send(sendPacket);
            System.out.println("Sent message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
   public void closeSocket(){
    this.socket.close();
   }
}

