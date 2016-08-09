package com.pahomov.machine;

public class Trailer extends AbstractMachine {

    private int capacity;
    private String type = "Trailer";
    final int acceleration = 0;

    public Trailer() {

    }

    public Trailer(String aName, int aMassa, double aMaxSpeed, int aCapacity) {
        name = aName;
        massa = aMassa;
        maxSpeed = aMaxSpeed;
        capacity = aCapacity;
    }

    public Trailer(String aName, int aMassa, double aMaxSpeed) {
        name = aName;
        massa = aMassa;
        maxSpeed = aMaxSpeed;
    }

    public String getType() {
        return type;
    }

}
