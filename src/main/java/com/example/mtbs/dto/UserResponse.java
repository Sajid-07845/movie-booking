package com.example.mtbs.dto;

import com.example.mtbs.enums.UserRole;

import java.time.LocalDate;

public record UserResponse(
        String username,
        String email,
        String phoneNumber,
        UserRole userRolel,
        LocalDate dateOfBirth
)
{
}
