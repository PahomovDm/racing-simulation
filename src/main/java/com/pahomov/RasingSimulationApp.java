package com.pahomov;

import java.util.ArrayList;

import com.pahomov.machine.*;

public class RasingSimulationApp {
    ArrayList<InterfaceMachine> autoList = new ArrayList<InterfaceMachine>();
    Machine auto = new Machine();

    public static void main(String[] args) {
        RasingSimulationApp myTest = new RasingSimulationApp();
        myTest.run();
    }

    private void getInfo() {
        System.out.println("Racing Simulation");
    }

    private void inputMachine() {
        autoList.add(auto.inputMachine());
    }

    private void run() {
        getInfo();
    }
}
