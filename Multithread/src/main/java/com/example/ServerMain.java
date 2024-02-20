package com.example;

import com.example.Server.Server;

/**
 * Hello world!
 *
 */
public class ServerMain 
{
    public static void main( String[] args )
    {           int serverPort = 4050;
                Server server = new Server(serverPort);
                server.runServer();
    }
}
