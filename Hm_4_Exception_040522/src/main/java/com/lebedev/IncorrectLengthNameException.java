package com.lebedev;

public class IncorrectLengthNameException extends Exception{
    public IncorrectLengthNameException() {
    }

    public IncorrectLengthNameException(String message) {
        super(message);
    }
}
