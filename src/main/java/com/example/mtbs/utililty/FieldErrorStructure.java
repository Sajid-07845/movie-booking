package com.example.mtbs.utililty;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FieldErrorStructure <t>
{
    private  int statusCode;
    @JsonProperty(namespace = "error_message")
    private String errorMessage;
    t data;

}
