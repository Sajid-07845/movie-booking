package com.example.mtbs.exception;

public class TheaterNotFoundByIdException extends RuntimeException
{
    public TheaterNotFoundByIdException(String message) {
        super(message);
    }
}
