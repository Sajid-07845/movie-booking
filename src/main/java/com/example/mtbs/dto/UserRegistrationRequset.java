package com.example.mtbs.dto;

import com.example.mtbs.enums.UserRole;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

//dto(Data transfer object)
public record UserRegistrationRequset(
        @NotNull
        String username,
        @NotNull
        String email,
        @NotNull
        String phoneNumber,
        @NotNull
        String password,
        UserRole userRole,
        LocalDate dateOfBirth
) {}
