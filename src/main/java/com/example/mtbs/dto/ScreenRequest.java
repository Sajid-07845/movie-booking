package com.example.mtbs.dto;

import com.example.mtbs.enums.ScreenType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ScreenRequest (
        @NotNull(message = "screen type is required")
        ScreenType screenType,
        @NotNull
        @Min(value = 1,message = "capacity cannot be null")
        Integer capacity,
        @NotNull
        @Min(value = 1,message = "rows cannot be null")
        Integer noOfRows
)
{
}
