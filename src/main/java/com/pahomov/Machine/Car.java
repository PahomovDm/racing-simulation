package com.pahomov.Machine;

public class Car extends AbstractMachine {

    public Car(Trailer trailer) {
        super();
        allMassa += massa + trailer.getMassa() + trailer.getMassaCargo();
        maxSpeed = Math.min(maxSpeed, trailer.getMaxSpeed());
        setAcceleration();
    }

    public Car() {
        super();
    }

    public Car(int aMassa, int aAcceleration, int aDistance) {
        massa = aMassa;
        acceleration = aAcceleration;
        distance = aDistance;
    }

    @Override
    public void calkSpeed() {

    }

    @Override
    public void calkDistance() {
        // TODO Auto-generated method stub
    }

    @Override
    public void loseSpeed() {
        // TODO Auto-generated method stub
    }

}
