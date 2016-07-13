package com.pahomov;

import com.pahomov.greet.*;
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
    private User2 user;

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
            scan.nextLine();
        } while (("\n").equals(scan.nextLine()));
    }

    private void run() {
        LOG.info("Start");
        try {
            getInfo();
            user = new User2.Builder().name().birthday().build();
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
// интерфейс с методами риднэйм и ридбёздэй
// источник данных
