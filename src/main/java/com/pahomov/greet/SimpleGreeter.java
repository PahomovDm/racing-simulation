package com.pahomov.greet;

import com.pahomov.UserBuilder.User;

/**
 * @dpahomov
 * @version 1.0
 */

public class SimpleGreeter implements Greeter {

    @Override
    public void greetUser(User user) {
        System.out.printf("Hi %s! This is Racing Simulator.", user.getName());
    }

}
