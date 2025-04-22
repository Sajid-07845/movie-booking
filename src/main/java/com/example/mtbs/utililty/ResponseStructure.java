package com.example.mtbs.utililty;

import com.example.mtbs.entity.UserDetails;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseStructure <t>
{
    private int status;
    private String message;
    private  t data;
}
