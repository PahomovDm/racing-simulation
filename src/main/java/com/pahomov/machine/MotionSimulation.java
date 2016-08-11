package com.pahomov.machine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MotionSimulation {
    private final int timeOutCalculation = 1000;
    private final int timeOutPrint = 5000;
    private String name;
    private int massa;
    private double speed;
    private double maxSpeed;
    private double acceleration;
    private double distance;
    private ScheduledExecutorService service;
    private int time;

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public MotionSimulation(AbstractMachine machine) {
        name = machine.getName();
        massa = machine.getAllMassa(); // кг
        maxSpeed = machine.getMaxSpeed() / 3.6; // м*сек
        acceleration = machine.getAcceleration();
    }

    public void calculateDistance() {
        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {

                if (calculateSpeed() < maxSpeed) {
                    distance = 0.5 * acceleration * time * time;

                } else {
                    distance += speed;

                }
                time++;
            }
        }, 0, timeOutCalculation, TimeUnit.MILLISECONDS);
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

    public void printToConsole() {
        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.printf("%s Расстояние %.2f скорость %.2f\n", name, distance, speed);
            }
        }, 0, (long) timeOutPrint, TimeUnit.MILLISECONDS);
    }
}
