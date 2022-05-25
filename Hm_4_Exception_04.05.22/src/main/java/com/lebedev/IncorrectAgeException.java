package com.lebedev;

public class IncorrectAgeException extends Exception{
    public IncorrectAgeException() {
    }

    public IncorrectAgeException(String message) {
        super(message);
    }
}
