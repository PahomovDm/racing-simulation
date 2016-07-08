package com.pahomov;

import com.pahomov.greet.*;

import java.util.GregorianCalendar;
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
    private KidGreeter kidGreeter = new KidGreeter();
    private GregorianCalendar birthday;

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

    private void closeProgram() {
        do {
            System.out.print("Press <Enter> to exit...");
            scan.nextLine();
        } while (("\n").equals(scan.nextLine()));
    }

    private static boolean checkName(String aName) {
        Pattern p = Pattern.compile("[\\p{IsAlphabetic}]{2,15}");
        Matcher m = p.matcher(aName);
        return m.matches();
    }

    private GregorianCalendar readBirthDay() {
        int day, month, year;
        System.out.println("Enter you birthday: ");
        day = scan.nextInt();
        month = scan.nextInt() - 1;
        year = scan.nextInt();
        birthday = new GregorianCalendar(year, month, day);
        return birthday;
    }

    private boolean checkAge(GregorianCalendar birthday) {
        GregorianCalendar checkDay = new GregorianCalendar(2016, 6, 8);
        int years = checkDay.get(GregorianCalendar.YEAR) - birthday.get(GregorianCalendar.YEAR);
        int cheMonth = checkDay.get(GregorianCalendar.MONTH);
        int birMonth = birthday.get(GregorianCalendar.MONTH);
        if (cheMonth < birMonth) {
            years--;
        } else if ((cheMonth == birMonth)
                && checkDay.get(GregorianCalendar.DAY_OF_MONTH) < birthday.get(GregorianCalendar.DAY_OF_MONTH)) {
            years--;
        }

        return !(years < 18);
    }

    private void run() {
        LOG.info("Start");
        try {
            getInfo();
            readName();
            if (checkAge(readBirthDay())) {
                greeter.greetUser(name);
            } else {
                kidGreeter.greetUser();
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
