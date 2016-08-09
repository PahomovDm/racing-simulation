package com.pahomov.machine.builder;

import com.pahomov.machine.Truck;

public class BuilderTruck extends AbstractMachineBuilder implements InterfaceBuildTruck {

    private double acceleration;
    private int massaCargo;

    ConsoleDataSource machine = new ConsoleDataSource();

    @Override
    public InterfaceBuildTruck name() {
        machine.name();
        this.name = machine.getName();
        return this;
    }

    @Override
    public InterfaceBuildTruck massa() {
        machine.massa();
        massa = machine.getMassa();
        return this;
    }

    @Override
    public InterfaceBuildTruck maxSpeed() {
        machine.maxSpeed();
        maxSpeed = machine.getMaxSpeed();
        return this;
    }

    @Override
    public InterfaceBuildTruck acceleration() {
        machine.acceleration();
        acceleration = machine.getAcceleration();
        return this;
    }

    @Override
    public InterfaceBuildTruck massaCargo() {
        machine.massaCargo();
        acceleration = machine.getMassaCargo();
        return this;
    }

    @Override
    public Truck build() {
        return new Truck(name, massa, maxSpeed, acceleration, massaCargo);
    }

}
