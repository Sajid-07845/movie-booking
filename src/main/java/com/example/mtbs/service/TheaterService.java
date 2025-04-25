package com.example.mtbs.service;

import com.example.mtbs.dto.TheatorRequest;
import com.example.mtbs.dto.TheatorResponse;
import jakarta.validation.Valid;

public interface TheaterService
{

    TheatorResponse addTheator(@Valid String email, TheatorRequest theatorRequest);

    TheatorResponse findTheaterById(String theaterId);

    TheatorResponse updateTheater(String theaterId, TheatorRequest registerationRequest);

}
