package com.ds.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Process3 {

    public static void main(String[] args){
        //client msg sending
    }
    public void run() throws IOException {
        listen();
    }

    public void send(){
        //TODO: automate the process of sending messages to server.
    }

    public void listen() throws IOException {
        ServerSocket servSock = new ServerSocket(2023);
        System.out.println("Process 3 starting to listen on port 2023.");
        Socket sock = null;
        sock = servSock.accept();
        System.out.println("Connection established!");

        InputStreamReader ip = new InputStreamReader(sock.getInputStream());
        BufferedReader br = new BufferedReader(ip);

        String msg = br.readLine();
        System.out.println("Client says: "+msg);
    }
}
