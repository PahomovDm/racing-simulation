package com.pahomov.machine.builder;

import com.pahomov.machine.Bus;

public class BuilderBus extends AbstractMachineBuilder implements InterfaceBuildBus {

    private double acceleration;
    private int people;

    ConsoleDataSource machine = new ConsoleDataSource();

    @Override
    public InterfaceBuildBus name() {
        machine.name();
        this.name = machine.getName();
        return this;
    }

    @Override
    public InterfaceBuildBus massa() {
        machine.massa();
        massa = machine.getMassa();
        return this;
    }

    @Override
    public InterfaceBuildBus maxSpeed() {
        machine.maxSpeed();
        maxSpeed = machine.getMaxSpeed();
        return this;
    }

    @Override
    public InterfaceBuildBus acceleration() {
        machine.acceleration();
        acceleration = machine.getAcceleration();
        return this;
    }

    @Override
    public InterfaceBuildBus people() {
        machine.people();
        acceleration = machine.getPeople();
        return this;
    }

    @Override
    public Bus build() {
        return new Bus(name, massa, maxSpeed, acceleration, people);
    }

}
