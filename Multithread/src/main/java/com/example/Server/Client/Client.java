package com.example.Server.Client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class Client {
    private  int port ;
    private InetAddress host;
    private Socket socket=null;
    
    public Client (int _port,String _host) throws IOException{
                port = _port;
                host = InetAddress.getByName(_host);
    }

    public String GetReversedString(String str){
        String reversedStr=null;
        for (int i=0;i<10;i++){
            try{
                socket = new Socket(host,port);
                PrintWriter output = new PrintWriter(socket.getOutputStream());
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output.println(str);
                output.flush();
                reversedStr = input.readLine();
                break;
                
            }
            catch (ConnectException e) {
                System.err.println("Server is busy. Please try again later.");
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException er){
                    System.out.println("error sending the message ");
                }
                
            }catch(IOException err){
                System.out.println("error sending message to server");
                err.printStackTrace();
                break;
            }
            
        }
        if (reversedStr==null){
            throw new RuntimeException("Server not Working ");
        }
        return reversedStr;
    }


}
