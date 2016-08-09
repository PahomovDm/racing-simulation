package com.pahomov.machine;

import com.pahomov.dao.Identified;
import java.io.Serializable;

public abstract class AbstractMachine implements Identified<Integer>, Serializable {
    protected int id;

    public Integer getId() {
        return id;
    }

    protected String type;
    protected String name;
    protected int massa;
    protected double maxSpeed;
    protected int allMassa;
    protected double acceleration;
    protected double speed = 0;
    protected double x;

    protected AbstractMachine(String aName, int aMassa, double aMaxSpeed, double aAcceleration) {
        name = aName;
        massa = aMassa;
        maxSpeed = aMaxSpeed;
        acceleration = aAcceleration;
    }

    public AbstractMachine() {
    }

    public String getName() {
        return name;
    }

    public int getMassa() {
        return massa;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public int getAllMassa() {
        return allMassa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMassa(int massa) {
        this.massa = massa;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void setAllMassa(int allMassa) {
        this.allMassa = allMassa;
    }

    public void setId(int aId) {
        id = aId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSpeed() {
        return speed;
    }

    public double getX() {
        return x;
    }

    public String toString() {
        return getId() + " " + getType() + " " + getName() + " " + getMassa() + "кг " + getMaxSpeed() + "км/ч "
                + getAcceleration() + "км/ч^2\n";
    }

    public void calcX(int t) {
        x = acceleration * t * t / 2;
        speed = acceleration * t * t;
    }

}
