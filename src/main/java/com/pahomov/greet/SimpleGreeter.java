package com.pahomov.greet;

/**
 * @dpahomov
 * @version 1.0
 */

class SimpleGreeter implements Greeter {

    @Override
    public void greetUser(String userName) {

        System.out.printf("Hello %s! This is Racing Simulator\n", userName);
    }

}
