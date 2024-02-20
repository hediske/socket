package com.example.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerRunnable implements Runnable{
    private Socket soc ;
    ServerRunnable(Socket _soc){
        soc=_soc;
    }

    @Override
    public void run(){
        try{
            System.out.println("Runnning the runner");
            BufferedReader input = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter output = new PrintWriter(soc.getOutputStream());
            
            String str = input.readLine();   
            output.println(reverse(str)); 
            System.out.println(reverse(str));
            output.flush();
        }
        catch(IOException e){
            System.out.println("Internal error happend");
        }
        finally{
            try{
                soc.close();
            }
            catch(IOException e){
                System.out.println("error closing the socket");
            }
        }
        
    }

    private String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
}
