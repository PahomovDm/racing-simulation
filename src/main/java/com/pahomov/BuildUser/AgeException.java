package com.pahomov.BuildUser;

public class AgeException extends Exception {
    private int age;

    public AgeException(String message, int age) {
        super(message);
    }
}
