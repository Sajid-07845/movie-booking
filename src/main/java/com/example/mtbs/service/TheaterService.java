package com.example.mtbs.service;

import com.example.mtbs.dto.TheatorRegistrationRequest;
import com.example.mtbs.dto.TheatorResponse;
import com.example.mtbs.entity.Theater;
import jakarta.validation.Valid;

public interface TheaterService
{

    TheatorResponse addTheator(@Valid String email, TheatorRegistrationRequest theatorRegistrationRequest);
}
