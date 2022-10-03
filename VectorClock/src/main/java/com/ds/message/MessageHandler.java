package com.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageHandler implements Runnable {
    private final Socket sock;

    public MessageHandler(Socket sock){
        this.sock = sock;
    }

    public void run(){
        PrintWriter pw = null;
        BufferedReader br =  null;

        try{
            pw = new PrintWriter(sock.getOutputStream(),true);
            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String msg;

            while ((msg = br.readLine())!= null){
                System.out.println("message received from client0 is: "+msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
