package com.example.mtbs.exception.handler;

import com.example.mtbs.exception.TheaterNotFoundByIdException;
import com.example.mtbs.utililty.ErrorStruture;
import com.example.mtbs.utililty.RestErrorBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class TheaterExceptionHandler
{
    private RestErrorBuilder restErrorBuilder;

    @ExceptionHandler(TheaterNotFoundByIdException.class)
    public ResponseEntity<ErrorStruture<String>> handleTheatorNotFoundByIdException(TheaterNotFoundByIdException ex)
    {
        return restErrorBuilder.failure(ex, HttpStatus.NOT_FOUND,"User with this Id not exist");
    }
}
