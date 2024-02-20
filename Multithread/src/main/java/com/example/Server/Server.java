package com.example.Server;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Server
 */
public class Server {

    private int port=2050;
    private ServerSocket serverSocket ;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);       
    
    
    public Server(int _port){
        port=_port;
    }

    public void runServer(){
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Launched the server");
                while(true)
                {
                    System.out.println("Waiting for the request  !");
                    Socket soc = serverSocket.accept();
                    System.out.println("captured a request from   :   "+soc.getRemoteSocketAddress()  + "  on Port  : "+soc.getPort());
                    preProcess();/// in case nhab nzid pre wala post process
                    executorService.submit(new ServerRunnable(soc));
                    PostProcess();


            }
  
        }
        catch(IOException e){
            System.out.println("Internal Error occured  !");
        }
    }

    void PostProcess(){};
    void preProcess(){};

    public void CLoseServer(){
        try {
            if(serverSocket!=null)
            serverSocket.close();
            
        } catch (Exception e) {
            System.out.println("Error closing the server");
        }finally{
            executorService.shutdown();
            System.out.println("server Terminated");
        }
    }
        
}