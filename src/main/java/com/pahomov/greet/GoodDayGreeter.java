package com.pahomov.greet;

public class GoodDayGreeter implements Greeter {

    protected Greeter greeter;

    public GoodDayGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    public void greetUser(String userName) {
        greeter.greetUser(userName);
        System.out.println(". Have a nice day!");
    }
}
