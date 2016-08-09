package com.pahomov.machine.builder;

import com.pahomov.machine.Car;

public class BuilderCar extends AbstractMachineBuilder implements InterfaceBuildCar {

    private double acceleration;

    ConsoleDataSource machine = new ConsoleDataSource();

    public BuilderCar name() {
        machine.name();
        this.name = machine.getName();
        return this;
    }

    public BuilderCar massa() {
        machine.massa();
        massa = machine.getMassa();
        return this;
    }

    public BuilderCar maxSpeed() {
        machine.maxSpeed();
        maxSpeed = machine.getMaxSpeed();
        return this;
    }

    public BuilderCar acceleration() {
        machine.acceleration();
        acceleration = machine.getAcceleration();
        return this;
    }

    public Car build() {
        return new Car(name, massa, maxSpeed, acceleration);
    }
}
