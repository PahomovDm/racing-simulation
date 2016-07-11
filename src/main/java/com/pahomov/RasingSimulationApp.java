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

    private static final int AGE_FOR_PROGRAMM = 18;
    public static final Logger LOG = Logger.getLogger(RasingSimulationApp.class);
    private Scanner scan = new Scanner(System.in);
    private Greeter greeter = new GoodDayGreeter(new SimpleGreeter());
    private Greeter kidGreeter = new KidGreeter();

    public static void main(String[] args) {
        RasingSimulationApp myTest = new RasingSimulationApp();
        myTest.run();
    }

    private void getInfo() {
        System.out.println("Program rasing-simulation\n");
    }

    private void readName() {
        do {
            System.out.println("Please enter your name:");
            User.setName(scan.nextLine());
            if (User.getName() == null) {
                throw new NullPointerException();
            }
        } while (!(checkName(User.getName())));
    }

    private void closeProgram() {
        do {
            System.out.print("\nPress <Enter> to exit...");
            scan.nextLine();
        } while (("\n").equals(scan.nextLine()));
    }

    private static boolean checkName(String aName) {
        Pattern p = Pattern.compile("[\\p{IsAlphabetic}]{2,15}");
        Matcher m = p.matcher(aName);
        return m.matches();
    }

    public void readBirthDay() {
        int day, month, year;
        System.out.println("Enter you birthday: ");
        day = scan.nextInt();
        month = scan.nextInt() - 1;
        year = scan.nextInt();
        User.setbBirthday(day, month, year);
    }

    private void run() {
        LOG.info("Start");
        try {
            getInfo();
            readName();
            readBirthDay();
            if (User.getAge() > AGE_FOR_PROGRAMM) {
                greeter.greetUser(User.getName());
            } else {
                kidGreeter.greetUser(User.getName());
            }
        } catch (NullPointerException e) {
            System.out.println("Null name, close program");
            LOG.error("NullPointerException");
        } finally {
            closeProgram();
            LOG.info("End");
        }
    }
}
// класс юзер. junit.
// если введено неверно др, то показать как правильно и предоставить ввод опять
