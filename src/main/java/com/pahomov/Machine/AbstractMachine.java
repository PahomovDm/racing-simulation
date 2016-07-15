package com.pahomov.Machine;

public abstract class AbstractMachine implements Machine {
    protected String name;
    protected int massa;
    protected int maxSpeed;
    protected double acceleration;

    @Override
    public abstract Machine calkSpeed();

    @Override
    public abstract Machine calkDistance();

    @Override
    public abstract Machine loseSpeed();

}
