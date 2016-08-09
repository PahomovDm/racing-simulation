package com.pahomov.machine.builder;

public abstract class AbstractMachineBuilder<T> {
    protected String name;
    protected int massa;
    protected double maxSpeed;

    protected abstract T build();
}
