/**
 *
 */
package com.pahomov.greet;

import com.pahomov.User2;

/**
 * @author dpahomov
 *
 */
public interface Greeter {

    default void greetUser(User2 user) {
        System.out.println("Hi " + user.getName());
    }
}
