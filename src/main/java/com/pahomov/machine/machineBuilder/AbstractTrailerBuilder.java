package com.pahomov.machine.machineBuilder;

public abstract class AbstractTrailerBuilder implements TrailerBuilder {
    protected int maxSpeed;
    protected int massa;

    @Override
    public abstract TrailerBuilder maxSpeed();

    @Override
    public abstract TruckBuilder massa();

}
