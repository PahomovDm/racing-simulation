package com.pahomov.greet;

import com.pahomov.Exception.*;
import com.pahomov.UserBuilder.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * @author dpahomov
 *
 */

public class GreeterApp {

    public static final Logger LOG = Logger.getLogger(GreeterApp.class);
    private Scanner scan = new Scanner(System.in);
    private CreateGreeter factory = new CreateGreeter();
    // private Greeter greeter;
    private List<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        GreeterApp myTest = new GreeterApp();
        myTest.run();
    }

    private void getInfo() {
        System.out.println("Program rasing-simulation\n");
    }

    private void closeProgram() {
        do {
            System.out.print("\nPress <Enter> to exit...");
        } while (("\n").equals(scan.nextLine()));
    }

    private void inputUsers() {
        do {
            try {
                users.add(new ConsoleUserBuilder().name().birthday().build());
            } catch (AgeException ex) {
                System.out.println(ex.getMessage());
            } catch (DateTimeException ex) {
                System.out.println(ex.getMessage());
            } catch (NullNameException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.print("\nClick <0> to add");
        } while (scan.nextInt() == 0);
    }

    private void outputUsers() {
        Collections.sort(users);
        users.stream().forEachOrdered(u -> factory.factoryGreeter(u).greetUser(u));
    }

    private void run() {
        LOG.info("Start");
        try {
            getInfo();
            inputUsers();
            outputUsers();
        } finally {
            closeProgram();
            LOG.info("End");
        }
    }
}
// прочитать про базы данных
