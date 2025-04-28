package com.example.mtbs.exception;

public class ScreenNotFoundByIdException extends RuntimeException
{
    public ScreenNotFoundByIdException(String message) {
        super(message);
    }
}
