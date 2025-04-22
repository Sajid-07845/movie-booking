package com.example.mtbs.utililty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponseBuilder
{
    public <t> ResponseEntity<ResponseStructure<t>> success (HttpStatus status,String message, t data)
    {
        ResponseStructure<t> responseStructure = ResponseStructure
                .<t>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(responseStructure);
    }
}
