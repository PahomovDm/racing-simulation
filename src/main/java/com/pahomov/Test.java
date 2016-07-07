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
            if (name == null) {
                throw new NullPointerException("Name is null");
            }
        } while (!(checkName(name)));
    }

    private void helloName() {
        System.out.printf("Hello %s! This is Racing Simulator\n", name.trim());
    }

    private void equalsEnter() {
        do {
            System.out.print("Press <Enter> to exit...");
        } while (("\n").equals(scan.nextLine()));
    }

    private static boolean checkName(String aName) {
        Pattern p = Pattern.compile("[p{IsAlphabetic}\\p{Space}]{2,15}");
        Matcher m = p.matcher(aName);
        return m.matches();
    }

    private void run() {
        LOG.info("Start");
        try {
            getInfo();
            readName();
            helloName();
            equalsEnter();
            LOG.info("End");
        } catch (NullPointerException e) {
            System.out.println("");
            System.exit(1);
            LOG.error("NullPointerException");
        }
    }
}
