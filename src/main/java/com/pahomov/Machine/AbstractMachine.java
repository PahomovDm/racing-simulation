package com.pahomov.Machine;

public abstract class AbstractMachine implements InterfaceMachine {
    protected String name;
    protected int massa;
    protected int maxSpeed;
    protected double acceleration;

    public AbstractMachine() {

    }

    @Override
    public abstract InterfaceMachine calkSpeed();

    @Override
    public abstract InterfaceMachine calkDistance();

    @Override
    public abstract InterfaceMachine loseSpeed();

}
