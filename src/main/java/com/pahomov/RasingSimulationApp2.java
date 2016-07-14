package com.pahomov;

import com.pahomov.BuildUser.*;
import com.pahomov.greet.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * @author dpahomov
 *
 */

public class RasingSimulationApp2 {

    public static final Logger LOG = Logger.getLogger(RasingSimulationApp2.class);
    private Scanner scan = new Scanner(System.in);
    private CreateGreeter factory = new CreateGreeter();
    // private Greeter greeter;
    private List<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        RasingSimulationApp2 myTest = new RasingSimulationApp2();
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
            users.add(new User(new ConsoleUserBuilder().name().birthday()));
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
