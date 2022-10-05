package com.ds.message;

import java.io.*;
import java.net.Socket;

public class MessageHandler extends Thread {
    private final Socket sock;

    PrintWriter pw;
    BufferedReader br;

    public MessageHandler(Socket sock) throws IOException {
        this.sock = sock;
        br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        pw = new PrintWriter(sock.getOutputStream(),true);
    }


    public void run(){


        try{
            while(true){
                String msg = br.readLine();
                System.out.println("message received:: "+msg);
            }
        } catch (Exception e) {
            System.out.println("Error encoutered!");
            e.printStackTrace();
        } finally {
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
