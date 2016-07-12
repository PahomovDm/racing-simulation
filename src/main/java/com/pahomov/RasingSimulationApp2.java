package com.pahomov;

import com.pahomov.greet.*;

import java.time.LocalDate;
//import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author dpahomov
 *
 */

public class RasingSimulationApp2 {

    public static final Logger LOG = Logger.getLogger(RasingSimulationApp2.class);
    private Scanner scan = new Scanner(System.in);
    private CreateGreeter factory = new CreateGreeter();
    private Greeter greeter;
    private User user = new User();

    public static void main(String[] args) {
        RasingSimulationApp2 myTest = new RasingSimulationApp2();
        myTest.run();
    }

    private void getInfo() {
        System.out.println("Program rasing-simulation\n");
    }

    private void readName() {
        do {
            System.out.println("Please enter your name:");
            user.setName(scan.nextLine());
            if (user.getName() == null) {
                throw new NullPointerException();
            }
        } while (!(checkName(user.getName())));
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
        System.out.print("Enter you birthday: \nDay ");
        day = scan.nextInt();
        System.out.print("Month ");
        month = scan.nextInt();
        System.out.print("Year ");
        year = scan.nextInt();
        LocalDate birthday = LocalDate.of(year, month, day);
        user.setBirthday2(birthday);
    }

    private void run() {
        LOG.info("Start");
        try {
            getInfo();
            readName();
            readBirthDay();
            LOG.info(user.getAge());
            greeter = factory.factoryGreeter(user);
            greeter.greetUser(user.getName());
        } catch (NullPointerException e) {
            System.out.println("Null name, close program");
            LOG.error("NullPointerException");
        } catch (RuntimeException e) {
            System.out.println("You are not born");
            LOG.error("RuntemeExcetion, age < 0");
        } finally {
            closeProgram();
            LOG.info("End");
        }
    }
}
// шаблон строитель
// несколько пользователей, приветствие по возрасту.
// приветствие в функциональном стиле.
// вывод приветствия через поток
