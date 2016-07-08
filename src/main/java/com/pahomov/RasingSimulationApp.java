package com.pahomov;

import com.pahomov.greet.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author dpahomov
 *
 */

public class RasingSimulationApp {

    public static final Logger LOG = Logger.getLogger(RasingSimulationApp.class);
    private Scanner scan = new Scanner(System.in);
    private String name;
    private Greeter greeter = new GoodDayGreeter(new SimpleGreeter());

    public static void main(String[] args) {
        RasingSimulationApp myTest = new RasingSimulationApp();
        myTest.run();
    }

    private void getInfo() {
        System.out.println("Program rasing-simulation\n");
    }

    private String readName() {
        do {
            System.out.println("Please enter your name:");
            name = scan.nextLine();
            if (name == null) {
                throw new NullPointerException();
            }
        } while (!(checkName(name)));
        return name;
    }

    private void equalsEnter() { // переименовать
        do {
            System.out.print("\nPress <Enter> to exit...");
        } while (("\n").equals(scan.nextLine()));
    }

    private static boolean checkName(String aName) {
        Pattern p = Pattern.compile("[\\p{IsAlphabetic}]{2,15}");
        Matcher m = p.matcher(aName);
        return m.matches();
    }

    private void run() {
        LOG.info("Start");
        try {
            getInfo();
            readName();
            greeter.greetUser(name);
            equalsEnter();
            LOG.info("End");
        } catch (NullPointerException e) {
            System.out.println("Null name, close program");
            LOG.error("NullPointerException");
            System.exit(1);
        }
        // файнали
    }
}
// ввод даты рождения. проверить на 18+, если меньше - нет доступа.
