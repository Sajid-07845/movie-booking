package com.example.mtbs.utililty;

import com.example.mtbs.exception.UserExistByEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestErrorBuilder
{
    public <t> ResponseEntity<ErrorStruture<String>> failure (RuntimeException ex,HttpStatus status, String data)
    {
        ErrorStruture<String> stringErrorStruture = ErrorStruture.<String>builder()
                .errorCode(status.value())
                .error(ex.getMessage())
                .data(data)
                .build();
        
        return ResponseEntity.status(status)
                .body(stringErrorStruture);

    }
}
