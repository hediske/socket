package com.example.UDP;

import java.net.*;

public class UDPServer {

    public UDPServer(int port) {

            DatagramSocket socket = null;
            try {
                socket = new DatagramSocket(port);
                byte[] receiveData = new byte[1024];
                while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received message: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null)
            socket.close();
        }
    }
}

