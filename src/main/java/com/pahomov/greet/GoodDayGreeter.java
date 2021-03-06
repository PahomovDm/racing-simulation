package com.pahomov.greet;

import org.apache.log4j.Logger;

import com.pahomov.userBuilder.User;

public class GoodDayGreeter implements Greeter {

    protected Greeter greeter;
    public static final Logger LOG = Logger.getLogger(GoodDayGreeter.class);

    public GoodDayGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    public void greetUser(User u) {
        greeter.greetUser(u);
        System.out.println(" Have a nice day!");
    }
}
