package com.example.mtbs.exception.handler;

import com.example.mtbs.exception.ScreenNotFoundByIdException;
import com.example.mtbs.utililty.ErrorStruture;
import com.example.mtbs.utililty.RestErrorBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class ScreenExceptionHandler
{
    private final RestErrorBuilder restErrorBuilder;

    @ExceptionHandler(ScreenNotFoundByIdException.class)
    public ResponseEntity<ErrorStruture<String>> handleScreenNotFoundById(ScreenNotFoundByIdException ex)
    {
        return restErrorBuilder.failure(ex, HttpStatus.NOT_FOUND,"Screen not found by that particular Id");
    }
}
