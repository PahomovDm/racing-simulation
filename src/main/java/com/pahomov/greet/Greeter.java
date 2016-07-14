/**
 *
 */
package com.pahomov.greet;

import com.pahomov.UserBuilder.User;

/**
 * @author dpahomov
 *
 */
public interface Greeter {

    default void greetUser(User u) {
        System.out.println("Hi " + u.getName());
    }
}
