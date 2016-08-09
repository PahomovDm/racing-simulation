package com.pahomov.machine;

public class Car extends AbstractMachine {
    private Trailer trailer;
    private String type = "Car";
    protected double acceleration;

    public Car(String aName, int aMassa, double aMaxSpeed, double aAcceleration) {
        super(aName, aMassa, aMaxSpeed, aAcceleration);
    }

    public Car() {
        super();
    }

    public Car(String aName, int aMassa, double aMaxSpeed, double aAcceleration, Trailer aTrailer) {
        super(aName, aMassa, aMaxSpeed, aAcceleration);
        name = aName;
        trailer = aTrailer;
        allMassa = massa + trailer.getMassa();
        name = name + " " + trailer.getName();
        maxSpeed = Math.min(maxSpeed, trailer.getMaxSpeed());
    }

    public String getType() {
        return type;
    }
}
