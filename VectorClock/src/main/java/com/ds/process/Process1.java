package com.ds.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Process1 {

    public static void main(String[] args){
        //client msg sending
    }
//    int a,b,c,g,d;
    public void run() throws IOException {
        //thread starts listening on a port:
        //initialize vector clock
//        a = 0;
//        b = 0;
//        c = 0;
//        d = 0;
//
        listen();
    }

    public void send(){
        //TODO: automate the process of sending messages to server.
    }

    public void listen() throws IOException {
        ServerSocket servSock = new ServerSocket(2021);
        System.out.println("Process 1 starting to listen on port 2021.");
        Socket sock = null;
        sock = servSock.accept();
        System.out.println("Connection established!");

        InputStreamReader ip = new InputStreamReader(sock.getInputStream());
        BufferedReader br = new BufferedReader(ip);

        String msg = br.readLine();
        System.out.println("Client says: "+msg);
    }
}
