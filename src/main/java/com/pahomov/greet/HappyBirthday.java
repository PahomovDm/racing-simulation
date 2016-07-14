package com.pahomov.greet;

import com.pahomov.UserBuilder.User;

public class HappyBirthday implements Greeter {
    Greeter greeter;

    public HappyBirthday(Greeter greeter) {
        this.greeter = greeter;
    }

    public void greetUser(User u) {
        greeter.greetUser(u);
        System.out.print(" Happy Birthday to you!");
    }
}
