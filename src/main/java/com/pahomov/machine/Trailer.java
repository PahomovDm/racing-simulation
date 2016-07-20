package com.pahomov.machine;

import java.util.Scanner;

public class Trailer {
    private String name;
    private int massa;
    private int massaCargo;
    private int maxSpeed;
    Scanner scan = new Scanner(System.in);

    public Trailer() {

    }

    public int getMassa() {
        return massa;
    }
    public int getMassaCargo() {
        return massaCargo;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMassa(int massa) {
        this.massa = massa;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

}
