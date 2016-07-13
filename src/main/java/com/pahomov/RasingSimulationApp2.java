package com.pahomov;

import com.pahomov.greet.*;

import java.util.ArrayList;
//import java.util.Arrays;
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
    private Greeter greeter;
    private List<User2> user = new ArrayList<User2>();

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

    private void addUser() {
        do {
            user.add(new User2.Builder().name().birthday().build());
            System.out.print("\nClick <0> to add or <1> to continue ");
        } while (scan.nextInt() == 0);
    }

    private void getUsers() {
        for (User2 user : user) {
            greeter = factory.factoryGreeter(user);
            greeter.greetUser(user.getName());
        }
    }

    private void run() {
        LOG.info("Start");
        try {
            getInfo();
            addUser();
            Collections.sort(user);
            getUsers();
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
// интерфейс с методами риднэйм и ридбёздэй
