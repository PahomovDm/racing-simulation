package com.pahomov.machine.builder;

import java.util.Scanner;

public class ConsoleDataSource implements DataSource {
    Scanner scan = new Scanner(System.in);
    private String name;
    private int massa;
    private double maxSpeed;
    private double acceleration;
    private int people;
    private int massaCargo;

    @Override
    public DataSource name() {
        System.out.println("Введите имя");
        name = scan.nextLine();
        return this;
    }

    @Override
    public DataSource massa() {
        System.out.println("Введите массу");
        massa = scan.nextInt();
        return this;
    }

    @Override
    public DataSource maxSpeed() {
        System.out.println("Введите максимальную скорость");
        maxSpeed = scan.nextDouble();
        return this;
    }

    @Override
    public DataSource acceleration() {
        System.out.println("Введите ускорение");
        acceleration = scan.nextDouble();
        return this;
    }

    @Override
    public DataSource people() {
        System.out.println("Введите пассажиров");
        people = scan.nextInt();
        return this;
    }

    @Override
    public DataSource massaCargo() {
        System.out.println("Введите массу груза");
        massaCargo = scan.nextInt();
        return this;
    }

    public String getName() {
        return name;
    }

    public int getMassa() {
        return massa;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public int getPeople() {
        return people;
    }

    public int getMassaCargo() {
        return massaCargo;
    }

}
