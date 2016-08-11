package com.pahomov.machine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private final int timeOutCalculation = 1000;
    private final int timeOutPrint = 5000;
    private String name;
    private int massa;
    private double speed;
    private double maxSpeed;
    private double acceleration;
    private double distance;
    private ScheduledExecutorService serviceCalc;
    private ScheduledExecutorService servicePrint;
    private static int position = 0;

    private int time;

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public Simulation(AbstractMachine machine) {
        name = machine.getName();
        massa = machine.getAllMassa(); // кг
        maxSpeed = machine.getMaxSpeed() / 3.6; // м*сек
        acceleration = machine.getAcceleration();
    }

    public void calculateDistance(int aDistanceTrack) {
        serviceCalc = Executors.newSingleThreadScheduledExecutor();
        serviceCalc.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {

                if (calculateSpeed() < maxSpeed) {
                    distance = 0.5 * acceleration * time * time;
                } else {
                    distance += speed;

                }
                time++;

                if (distance > aDistanceTrack) {
                    serviceCalc.shutdownNow();
                    servicePrint.shutdownNow();
                    position++;
                    printWin();
                }
            }
        }, 100, timeOutCalculation, TimeUnit.MILLISECONDS);
    }

    private double calculateSpeed() {

        if (speed < maxSpeed) {
            speed += acceleration * time;
        }
        if (speed >= maxSpeed) {
            speed = maxSpeed;
        }
        return speed;
    }

    public void printToConsole() { // переименовать
        servicePrint = Executors.newSingleThreadScheduledExecutor();
        servicePrint.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.printf("%s Расстояние %.2f скорость %.2f\n", name, distance, speed);
            }
        }, 125, timeOutPrint, TimeUnit.MILLISECONDS);
    }

    public void printWin() {
        System.out.printf("%s доехал до финиша за %d секунд и расположился на %d месте\n", name, time, position);
    }

    // перенести в абстракт машину два потока
    // для просчета состояния отдельных поток. для вывода отдельный.
    // синхронизировать их
    // при достижении конца трассы через паттерн наблюдатель вывести действие.

}
