package com.pahomov.greet;

public class HappyBirthday implements Greeter {
    Greeter greeter;

    public HappyBirthday(Greeter greeter) {
        this.greeter = greeter;
    }

    public void greetUser(String userName) {
        greeter.greetUser(userName);
        System.out.print(" Happy Birthday to you!");
    }
}
