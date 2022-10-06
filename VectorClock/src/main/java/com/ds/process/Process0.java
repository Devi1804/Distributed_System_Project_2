package com.ds.process;

import com.ds.vector.Vector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static com.ds.vector.Vector.*;

public class Process0 {
    public static void main(String[] args) throws IOException {
        //Start listening:::
        listen();
    }

    public void send() throws IOException {
        //TODO: automate the process of sending messages to server.
        //client sending messages:
        Socket sock = new Socket("localhost",2021);
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter pw = new PrintWriter(sock.getOutputStream(),true);

        System.out.println("[CLIENT 0] vector time before sending the message<"+a+","+b+","+c+","+d+">");
        a +=1;
        pw.println("Vector time<"+ a+","+b+","+c+","+d+">");
        System.out.println("[CLIENT 0] vector time after sending the message<"+a+","+b+","+c+","+d+">");
    }

    public static void listen() throws IOException {

        ServerSocket servSock = new ServerSocket(2020);
        System.out.println("[SERVER 0] Process 0 starting to listen on port 2020.");
        Socket sock = null;
        sock = servSock.accept();
        System.out.println("[SERVER 0] Connection established!");

        InputStreamReader ip = new InputStreamReader(sock.getInputStream());
        BufferedReader br = new BufferedReader(ip);

        String msg = br.readLine();
        System.out.println("[SERVER 0] vector time received from client: "+msg);
    }

}
