package com.example.mtbs.exception.handler;

import com.example.mtbs.utililty.FieldErrorStructure;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class FieldErrorException extends ResponseEntityExceptionHandler
{
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
    {

       List<ObjectError> objectErrorList = ex.getAllErrors();

       List<CustomFieldError> customFieldErrors = new ArrayList<>();
       for(ObjectError objectError:objectErrorList)
       {
           if(objectError instanceof FieldError)
           {
               FieldError fieldError = (FieldError) objectError;
               customFieldErrors.add(CustomFieldError.builder()
                               .field(fieldError.getField())
                               .rejectedValue((String)fieldError.getRejectedValue())
                               .errorMessage(fieldError.getDefaultMessage())
                                .build());
           }

       }

       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(FieldErrorStructure.builder()
               .statusCode(HttpStatus.BAD_REQUEST.value())
               .errorMessage("Invalid input")
               .data(customFieldErrors)
               .build()
       );
    }

    @Getter
    @Builder
    public class CustomFieldError
    {
        String field;
        String rejectedValue;
        String errorMessage;
    }
}
