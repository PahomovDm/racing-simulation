package com.pahomov.machine.builder;

import com.pahomov.machine.Truck;

public interface InterfaceBuildTruck {
    InterfaceBuildTruck name();

    InterfaceBuildTruck massa();

    InterfaceBuildTruck maxSpeed();

    InterfaceBuildTruck acceleration();

    InterfaceBuildTruck massaCargo();

    Truck build();
}
