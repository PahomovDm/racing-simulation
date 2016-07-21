package com.pahomov.machine.builder;

public abstract class AbstractTrailerBuilder implements TrailerBuilder {
    protected int maxSpeed;
    protected int massa;

    @Override
    public abstract TrailerBuilder maxSpeed();

    @Override
    public abstract TruckBuilder massa();

}
