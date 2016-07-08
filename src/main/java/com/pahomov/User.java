package com.pahomov;

import java.util.GregorianCalendar;
import java.util.Scanner;

class User {
    private Scanner scan = new Scanner(System.in);
    private String name;
    private GregorianCalendar birthday;

    User() {
        System.out.println("Введите имя:");
        name = scan.nextLine();
        readBirthDay();
    }

    public void readBirthDay() {
    };

    public boolean checkName() {
        return false;
    }
}
