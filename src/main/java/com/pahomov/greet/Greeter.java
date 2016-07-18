/**
 *
 */
package com.pahomov.greet;

import com.pahomov.userBuilder.User;

/**
 * @author dpahomov
 *
 */
public interface Greeter {

    default void greetUser(User u) {
        System.out.println("Hi " + u.getName());
    }
}
