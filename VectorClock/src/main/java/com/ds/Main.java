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
//        Process0 p0 = new Process0();
//        p0.run();
//        System.out.println("process 0 running on port:");
//
//        Process1 p1 = new Process1();
//        p1.run();
//        System.out.println("process 1 running on port:");
//
//        Process2 p2 = new Process2();
//        p2.run();
//        System.out.println("process 2 running on port:");

        Process3 p3 = new Process3();
        p3.run();
        System.out.println("process 3 running on port:");
    }
}
