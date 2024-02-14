package com.example.TCP;


import java.io.*;
import java.net.*;

public class TCPClient {

    private String host;
    private int port;
    private Socket socket;
    public TCPClient(String host,int port){
        try {
            this.port =port ;
            this.host = host;
            this.socket = new Socket(host,port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(String message) throws IOException{
        PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);
        outToServer.println(message);
        System.out.println("Sent message: " + message);
    }

    public void closeSocket() throws IOException{
        this.socket.close();
    }
}