package com.example;

import com.example.Server.Client.Client;
import java.io.IOException;
/**
 * Hello world!
 *
 */
public class ClientMain 
{
    public static void main( String[] args )
    { 
        int port =4050;
        String host = "127.0.0.1";
        try 
        {
            Client client= new Client (port,host) ;
            String str =client.GetReversedString("Testing the server");
            System.out.println("resversed string is :  "+str);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
