package com.pahomov.greet;

/**
 * @dpahomov
 * @version 1.0
 */

public class SimpleGreeter implements Greeter {

    @Override
    public void greetUser(String userName) {
        System.out.printf("Hi %s! This is Racing Simulator", userName);
    }

}
