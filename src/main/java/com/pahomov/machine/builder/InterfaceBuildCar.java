package com.pahomov.machine.builder;

import com.pahomov.machine.Car;

public interface InterfaceBuildCar {
    InterfaceBuildCar name();

    InterfaceBuildCar massa();

    InterfaceBuildCar maxSpeed();

    InterfaceBuildCar acceleration();

    Car build();
}
