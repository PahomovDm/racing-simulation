package com.pahomov.Machine;

public abstract class AbstractMachine implements InterfaceMachine {
    protected String name;
    protected int massa;
    protected int maxSpeed;
    protected double acceleration;
    protected int speed;
    protected double distance;
    protected int allMassa;

    public AbstractMachine() {
    }

    @Override
    public void calkSpeed(int time) {
        speed += acceleration * time;
    };

    @Override
    public void calkDistance(int time) {
        distance -= acceleration * time * time / 2;

    };

    @Override
    public abstract void loseSpeed();

    public void setAcceleration() {
        acceleration = acceleration * (massa / allMassa);
    }

    public double getDistance() {
        return distance;
    }
}
