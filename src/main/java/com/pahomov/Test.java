package com.pahomov;

import java.util.Scanner;

import org.apache.log4j.Logger;



public class Test {
    
    public static final Logger LOG=Logger.getLogger(Test.class);
    private Scanner scan = new Scanner(System.in);
    private String name;

    public static void main(String[] args) {
        Test myTest = new Test();
        myTest.run();
    }

    private void getInfo() {
        System.out.println("Program rasing-simulation\n");
    }

    private void setName() {
        System.out.println("Please enter your name:");
        name = scan.nextLine();
    }

    private String trimLine() {
        if (name == null) {
            System.out.println("Null");
        }
        while (name.trim().equals("")) {
            System.out.println("Empty");
            setName();
        }
        return name;
    }

    private void helloName() {
        System.out.printf("Hello %s! This is Racing Simulator\n", name.trim());
    }

    private void equalsEnter() {
        while (("\n").equals(scan.nextLine())) {
            System.out.print("Press <Enter> to exit...");
        }
    }

    private void run() {
        getInfo();
        setName();
        trimLine();
        helloName();
        equalsEnter();
    }
}
