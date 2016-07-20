package com.pahomov.machine;

public abstract class AbstractMachine implements InterfaceMachine {
    protected String name;
    protected int massa;
    protected int maxSpeed;
    protected double acceleration;
    protected int speed;
    protected double distance;
    protected int allMassa;
// базы данных машин!, трасс, гонок, история для каждой машины
    public AbstractMachine() {
    }

    @Override
    public void calkSpeed(double time) {
        speed += acceleration * time;
    };

    @Override
    public void calkDistance(double time) {
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
