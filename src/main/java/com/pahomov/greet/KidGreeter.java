package com.pahomov.greet;

import com.pahomov.BuildUser.User;

public class KidGreeter implements Greeter {

    public void greetUser(User user) {

        System.out.print("You are young for this program");
    }
}
