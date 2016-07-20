package com.pahomov.machine;

public class CreateCar {
    Car car;

    public Car creat(boolean is) {
        if (is) {
            return car = new Car(new Trailer());
        } else {
            return car = new Car();
        }

    }
}
