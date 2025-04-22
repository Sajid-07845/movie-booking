package com.example.mtbs.exception.handler;

import com.example.mtbs.exception.UserExistByEmailException;
import com.example.mtbs.utililty.ErrorStruture;
import com.example.mtbs.utililty.RestErrorBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler
{
    private RestErrorBuilder restErrorBuilder;

    @ExceptionHandler(UserExistByEmailException.class)
    public ResponseEntity<ErrorStruture<String>> handleUserExistByEmailException( UserExistByEmailException ex)
    {

        return restErrorBuilder.failure(ex, HttpStatus.BAD_REQUEST,"user already exist");
    }
}
