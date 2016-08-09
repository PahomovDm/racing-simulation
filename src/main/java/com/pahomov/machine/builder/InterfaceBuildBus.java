package com.pahomov.machine.builder;

import com.pahomov.machine.Bus;

public interface InterfaceBuildBus {
    InterfaceBuildBus name();

    InterfaceBuildBus massa();

    InterfaceBuildBus maxSpeed();

    InterfaceBuildBus acceleration();

    InterfaceBuildBus people();

    Bus build();
}
