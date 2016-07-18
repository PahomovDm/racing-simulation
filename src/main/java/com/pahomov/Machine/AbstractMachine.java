package com.pahomov.Machine;

import java.util.Scanner;

public abstract class AbstractMachine implements InterfaceMachine {
    protected String name;
    protected int massa;
    protected int maxSpeed;
    protected double acceleration;
    Scanner scan = new Scanner(System.in);

    public AbstractMachine() {
        System.out.println("Введите массу, максимальную скорость и ускорение ");
        massa = scan.nextInt();
        maxSpeed = scan.nextInt();
        acceleration = scan.nextInt();
    }

    @Override
    public abstract InterfaceMachine calkSpeed();

    @Override
    public abstract InterfaceMachine calkDistance();

    @Override
    public abstract InterfaceMachine loseSpeed();

}
