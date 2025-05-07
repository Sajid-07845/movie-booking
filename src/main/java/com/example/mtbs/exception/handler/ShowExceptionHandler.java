package com.example.mtbs.exception.handler;

import com.example.mtbs.exception.ShowsConflictException;
import com.example.mtbs.utililty.ErrorStruture;
import com.example.mtbs.utililty.RestErrorBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@AllArgsConstructor
public class ShowExceptionHandler
{
    private final RestErrorBuilder restErrorBuilder;

    @ExceptionHandler(ShowsConflictException.class)
    public ResponseEntity<ErrorStruture<String>> handleShowsConflictException(ShowsConflictException ex)
    {
        return restErrorBuilder.failure(ex, HttpStatus.BAD_REQUEST,"Show cannot be added");
    }
}
