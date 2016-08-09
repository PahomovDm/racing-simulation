package com.pahomov.machine;

public class Bus extends AbstractMachine {

    private static int MASSAPEOPLE = 70;
    protected double acceleration;
    private int people;
    private String type = "Bus";

    public Bus() {
        super();
    }

    public Bus(String aName, int aMassa, double aMaxSpeed, double aAcceleration, int aPeople) {
        super(aName, aMassa, aMaxSpeed, aAcceleration);
        people = aPeople;
        allMassa = massa + people * MASSAPEOPLE;
    }

    public String getType() {
        return type;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

}
