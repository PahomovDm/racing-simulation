package com.pahomov.greet;

import org.apache.log4j.Logger;

import com.pahomov.RasingSimulationApp2;

public class GoodDayGreeter implements Greeter {

    protected Greeter greeter;
    public static final Logger LOG = Logger.getLogger(RasingSimulationApp2.class);

    public GoodDayGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    public void greetUser(String userName) {
        greeter.greetUser(userName);
        System.out.println(" Have a nice day!");
    }
}
