package com.pahomov;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author dpahomov
 *
 */
public class Test {

    public static final Logger LOG = Logger.getLogger(Test.class);
    private Scanner scan = new Scanner(System.in);
    private String name;

    public static void main(String[] args) {
        Test myTest = new Test();
        myTest.run();
    }

    private void getInfo() {
        System.out.println("Program rasing-simulation\n");
    }

    private void readName() {
        System.out.println("Please enter your name:");
        do {
            name = scan.nextLine();
        } while (!(checkRegExp(name)));
    }

    private void inspectionNull() {
        if (name == null) {
            throw new NullPointerException("Name is null");
        }
    }

    private void helloName() {
        System.out.printf("Hello %s! This is Racing Simulator\n", name.trim());
    }

    private void equalsEnter() {
        do {
            System.out.print("Press <Enter> to exit...");
        } while (("\n").equals(scan.nextLine()));
    }

    private static boolean checkRegExp(String aName) {
        Pattern p = Pattern.compile("[A-Za-z\\s]{2,15}");
        Matcher m = p.matcher(aName);
        return m.matches();
    }

    private void run() {
        LOG.info("Start");
        getInfo();
        try {
            readName();
        } catch (NullPointerException e) {
            System.exit(1);
            LOG.error("NullPointerException");
            }
        inspectionNull();
        helloName();
        equalsEnter();
        LOG.info("End");
    }
}
