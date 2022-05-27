package com.lebedev.exception;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Long id) {
        super("Could not find movie with id = " + id);
    }
    public MovieNotFoundException(String message, long id) {
        super(message + ": Could not find movie with id = " + id);
    }
}
