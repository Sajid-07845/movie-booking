package com.example.mtbs.exception.handler;

import com.example.mtbs.exception.MovieNotFoundByIdException;
import com.example.mtbs.exception.ShowsConflictException;
import com.example.mtbs.utililty.ErrorStruture;
import com.example.mtbs.utililty.RestErrorBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class MovieExceptionHandler
{
    private final RestErrorBuilder restErrorBuilder;

    @ExceptionHandler(MovieNotFoundByIdException.class)
    public ResponseEntity<ErrorStruture<String>> handleMovieNotFoundByIdException (MovieNotFoundByIdException ex)
    {
        return restErrorBuilder.failure(ex, HttpStatus.NOT_FOUND,"no movie found by this id");
    }

    @ExceptionHandler(ShowsConflictException.class)
    public ResponseEntity<ErrorStruture<String>> handleShowConflictException(ShowsConflictException ex)
    {
        return restErrorBuilder.failure(ex,HttpStatus.BAD_REQUEST,"already a show present by this timing");
    }
}
