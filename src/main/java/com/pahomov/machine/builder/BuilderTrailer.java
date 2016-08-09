package com.pahomov.machine.builder;

import com.pahomov.machine.Trailer;

public class BuilderTrailer extends AbstractMachineBuilder implements InterfaceBuildTrailer {

    ConsoleDataSource machine = new ConsoleDataSource();

    public InterfaceBuildTrailer name() {
        machine.name();
        this.name = machine.getName();
        return this;
    }

    public InterfaceBuildTrailer massa() {
        machine.massa();
        massa = machine.getMassa();
        return this;
    }

    public InterfaceBuildTrailer maxSpeed() {
        machine.maxSpeed();
        maxSpeed = machine.getMaxSpeed();
        return this;
    }

    @Override
    public Trailer build() {
        return new Trailer(name, massa, maxSpeed);
    }
}
