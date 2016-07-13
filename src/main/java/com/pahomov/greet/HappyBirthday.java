package com.pahomov.greet;

import com.pahomov.User2;

public class HappyBirthday implements Greeter {
    Greeter greeter;

    public HappyBirthday(Greeter greeter) {
        this.greeter = greeter;
    }

    public void greetUser(User2 user) {
        greeter.greetUser(null);
        System.out.print(" Happy Birthday to you!");
    }
}
