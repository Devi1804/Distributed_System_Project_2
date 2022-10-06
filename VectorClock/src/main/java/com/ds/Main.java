package com.ds;

import com.ds.process.Process0;
import com.ds.process.Process1;
import com.ds.process.Process2;
import com.ds.process.Process3;

import java.io.IOException;

public class Main {

    public static void main(String [] args) throws IOException {
        System.out.println("This is DS project2:");
        System.out.println("starting processes 0 to 3:");
        run();
    }

    private static void run() throws IOException {

        Process0 p0 = new Process0();
        System.out.println("Process 0 sending...");
        p0.send();
        Process1 p1 = new Process1();
        System.out.println("Process 1 sending...");
        p1.send();
        Process2 p2 = new Process2();
        System.out.println("Process 2 sending...");
        p2.send();
        Process3 p3 = new Process3();
        System.out.println("Process 3 sending...");
        p3.send();



    }
}
