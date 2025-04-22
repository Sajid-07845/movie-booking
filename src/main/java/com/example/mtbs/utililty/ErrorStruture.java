package com.example.mtbs.utililty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorStruture <t>
{
    private int errorCode;
    private String error;
    private t data;
}
