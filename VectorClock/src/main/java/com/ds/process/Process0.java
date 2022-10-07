package com.ds.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Process0 {
    public static int vector0;
    public static int vector1;
    public static int vector2;
    public static int vector3;

    public static void main(String[] args) throws IOException {
        vector0 = 0;
        vector1 = 0;
        vector2 = 0;
        vector3 = 0;
        listen();
        send();
    }

    // client sending messages:
    public static void send() throws IOException {

        try (Socket sock = new Socket("localhost", 2021)) {
            PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);

            System.out.println(
                    "[CLIENT 0] vector time before sending the message to server 1 <" + vector0 + "," + vector1 + "," + vector2 + ","
                            + vector3 + ">");
            vector0 += 1;
            pw.println(vector0 + "," + vector1 + "," + vector2 + "," + vector3);
        }
        System.out.println("[CLIENT 0] vector time after sending the message to server 1 <" + vector0 + "," + vector1 + "," + vector2
                + "," + vector3 + ">");
    }

    public static void listen() throws IOException {

        try (ServerSocket servSock = new ServerSocket(2020)) {
            System.out.println("[SERVER 0] Process 0 starting to listen on port 2020.");
            Socket sock = null;
            sock = servSock.accept();
            System.out.println("[SERVER 0] Connection established!");

            System.out.println("[SERVER 0] vector time before receiving the message<" + vector0 + "," + vector1 + ","
                    + vector2 + "," + vector3 + ">");
            InputStreamReader ip = new InputStreamReader(sock.getInputStream());
            BufferedReader br = new BufferedReader(ip);

            String msg = br.readLine();
            String[] arr = msg.split(",");
            vector0 += 1;
            vector1 = Integer.parseInt(arr[1]);
            vector2 = Integer.parseInt(arr[2]);
            vector3 = Integer.parseInt(arr[3]);
            System.out.println("[SERVER 0] vector time after receiving the message<" + vector0 + "," + vector1 + ","
                    + vector2 + "," + vector3 + ">");

        }
    }

}
