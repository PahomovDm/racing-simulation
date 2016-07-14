package com.pahomov.UserBuilder;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUserBuilder extends AbstractUserBuilder {

    private Scanner scan = new Scanner(System.in);

    @Override
    public ConsoleUserBuilder name() {
        do {
            System.out.println("Please enter your name:");
            name = (scan.nextLine());
        } while (!(checkName(name)));
        return this;
    }

    @Override
    public ConsoleUserBuilder birthday() {
        int day, month, year;
        System.out.print("Enter you birthday: \nDay ");
        day = scan.nextInt();
        System.out.print("Month ");
        month = scan.nextInt();
        System.out.print("Year ");
        year = scan.nextInt();
        birthday = LocalDate.of(year, month, day);
        return this;
    }

}
