package com.pahomov.Machine;

public class Car extends AbstractMachine {

    public Car(Trailer trailer) {
        new Car();
        massa += trailer.getMassa();
        maxSpeed = Math.min(maxSpeed, trailer.getMaxSpeed());
    }

    public Car() {
        super();
    }

    @Override
    public InterfaceMachine calkSpeed() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InterfaceMachine calkDistance() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InterfaceMachine loseSpeed() {
        // TODO Auto-generated method stub
        return null;
    }

}
