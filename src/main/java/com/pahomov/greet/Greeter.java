/**
 *
 */
package com.pahomov.greet;

/**
 * @author dpahomov
 *
 */
public interface Greeter {

    default void greetUser(String userName) {
        System.out.println("Hi " + userName);
    }
}
