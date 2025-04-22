package com.example.mtbs.dto;

import com.example.mtbs.enums.UserRole;

import java.time.LocalDate;

//dto(Data transfer object)
public record UserRegistrationRequset(
        String username,
        String email,
        String phoneNumber,
        String password,
        UserRole userRole,
        LocalDate dateOfBirth
) {}
