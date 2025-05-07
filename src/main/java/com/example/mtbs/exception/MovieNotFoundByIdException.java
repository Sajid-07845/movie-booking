package com.example.mtbs.exception;

public class MovieNotFoundByIdException extends RuntimeException {
    public MovieNotFoundByIdException(String message) {
        super(message);
    }
}
