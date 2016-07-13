package com.pahomov.greet;

import com.pahomov.User2;

/**
 * @dpahomov
 * @version 1.0
 */

public class SimpleGreeter implements Greeter {

    @Override
    public void greetUser(User2 user) {
        System.out.printf("Hi %s! This is Racing Simulator.", user.getName());
    }

}
