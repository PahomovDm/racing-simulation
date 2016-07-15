package com.pahomov;

import com.pahomov.Machine.Machine;

public class RasingSimulationApp {
    Machine auto = new Machine();

    public static void main(String[] args) {
        RasingSimulationApp myTest = new RasingSimulationApp();
        myTest.run();
    }

    private void run() {
        auto.inputMachine();
    }
}
