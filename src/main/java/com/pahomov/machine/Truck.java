package com.pahomov.machine;

public class Truck extends AbstractMachine {
    private int capacity;
    private String type = "Truck";
    protected double acceleration;

    public Truck() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Truck(String aName, int aMassa, double aMaxSpeed, double aAcceleration, int massaCargo) {
        super(aName, aMassa, aMaxSpeed, aAcceleration);
        allMassa = massa + massaCargo;
    }

    public String getType() {
        return type;
    }
}
