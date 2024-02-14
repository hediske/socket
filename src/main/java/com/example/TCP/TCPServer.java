package com.example.TCP;
import java.net.*;
import java.io.*;
public class TCPServer {
    public TCPServer(int port){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = inFromClient.readLine();
                System.out.println("Received message: " + message);
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    }
}