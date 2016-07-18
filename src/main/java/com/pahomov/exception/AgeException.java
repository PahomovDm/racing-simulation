package com.pahomov.exception;

public class AgeException extends Exception {
    /**
     * @author dpahomov
     */

    public AgeException(String message, int age) {
        super(message);
    }
}
