//package com.pahomov;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import com.pahomov.Machine.*;
//
//public class RasingSimulationApp {
//    ArrayList<AbstractMachine> autoList = new ArrayList<AbstractMachine>();
//    CreateMachine auto = new CreateMachine();
//    Scanner scan = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        RasingSimulationApp myTest = new RasingSimulationApp();
//        myTest.run();
//    }
//
//    private void getInfo() {
//        System.out.println("Racing Simulation");
//    }
//
//    private void inputMachine() {
//        System.out.println("Quantity CreateMachine? ");
//        for (int quantity = scan.nextInt(); quantity != 0; quantity--) {
//            autoList.add(auto.inputMachine());
//        }
//    }
//
//    private void run() {
//        getInfo();
//        inputMachine();
//    }
//}
