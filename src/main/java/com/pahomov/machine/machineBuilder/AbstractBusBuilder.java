package com.pahomov.machine.machineBuilder;

public abstract class AbstractBusBuilder implements BusBuilder {
    protected int maxSpeed;
    protected int massa;
    protected int quantityPeople;
    protected double acceleration;

    @Override
    public abstract BusBuilder maxSpeed();

    @Override
    public abstract BusBuilder massa();

    @Override
    public abstract BusBuilder acceleration();

    @Override
    public abstract BusBuilder quantityPeople();

}
