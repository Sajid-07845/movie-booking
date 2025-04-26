package com.example.mtbs.dto;


import com.example.mtbs.enums.ScreenType;

public record ScreenResponse (
        String screenId,
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows
)
{
}
