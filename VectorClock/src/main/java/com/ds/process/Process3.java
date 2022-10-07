package com.ds.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Process3 {

    public static int vector0;
    public static int vector1;
    public static int vector2;
    public static int vector3;

    public static void main(String[] args) throws IOException {
        vector0 = 0;
        vector1 = 0;
        vector2 = 0;
        vector3 = 0;
        send();
        listen();
    }

    // client sending messages:
    public static void send() throws IOException {

        try (Socket sock = new Socket("localhost", 2020)) {
            PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);

            System.out.println(
                    "[CLIENT 3] vector time before sending the message to server 0 <" + vector0 + "," + vector1 + "," + vector2 + ","
                            + vector3 + ">");
            vector3 += 1;
            pw.println(vector0 + "," + vector1 + "," + vector2 + "," + vector3);
            System.out.println("[CLIENT 3] vector time after sending the message to server 0 <" + vector0 + "," + vector1 + ","
                    + vector2 + "," + vector3 + ">");
        }
    }

    public static void listen() throws IOException {
        try (ServerSocket servSock = new ServerSocket(2023)) {
            System.out.println("[SERVER 3] Process 3 starting to listen on port 2023.");
            Socket sock = null;
            sock = servSock.accept();
            System.out.println("[SERVER 3] Connection established!");

            System.out.println("[SERVER 3] vector time before receiving the message<" + vector0 + "," + vector1 + ","
                    + vector2 + "," + vector3 + ">");
            InputStreamReader ip = new InputStreamReader(sock.getInputStream());
            BufferedReader br = new BufferedReader(ip);

            String msg = br.readLine();
            String[] arr = msg.split(",");
            vector0 = Integer.parseInt(arr[0]);
            vector1 = Integer.parseInt(arr[1]);
            vector2 = Integer.parseInt(arr[2]);
            vector3 += 1;
            System.out.println("[SERVER 3] vector time after receiving the message<" + vector0 + "," + vector1 + ","
                    + vector2 + "," + vector3 + ">");
        }
    }
}
