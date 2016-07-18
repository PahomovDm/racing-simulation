package com.pahomov;

import java.util.ArrayList;
import java.util.Scanner;

import com.pahomov.Machine.*;

public class RasingSimulationApp {
    ArrayList<AbstractMachine> autoList = new ArrayList<AbstractMachine>();
    CreateMachine auto = new CreateMachine();
    Scanner scan = new Scanner(System.in);
    Car car = new Car(300, 90, 100);
    int time = 0;

    public static void main(String[] args) throws InterruptedException {
        RasingSimulationApp myTest = new RasingSimulationApp();
        myTest.run();
    }

    private void getInfo() {
        System.out.println("Racing Simulation");
    }

    private void inputMachine() {
        System.out.println("How many machine? ");
        for (int quantity = scan.nextInt(); quantity != 0; quantity--) {
            autoList.add(auto.inputMachine());
        }
    }

    private void run() throws InterruptedException {
//        getInfo();
//        inputMachine();
        runSimulation();
        System.out.println("Прошло секунд " + time);
    }

    private void runSimulation() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            time++;
            car.calkSpeed(time);
            car.calkDistance(time);
            if (car.getDistance() < 0) {
                break;
            }
        }
    };
}
