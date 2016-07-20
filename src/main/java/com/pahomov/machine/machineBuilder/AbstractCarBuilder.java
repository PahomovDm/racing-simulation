package com.pahomov.machine.machineBuilder;

public abstract class AbstractCarBuilder implements CarBuilder {
    protected int maxSpeed;
    protected int massa;
    protected double acceleration;

    @Override
    public abstract CarBuilder maxSpeeds();

    @Override
    public abstract CarBuilder massa();

    @Override
    public abstract CarBuilder acceleration();

}