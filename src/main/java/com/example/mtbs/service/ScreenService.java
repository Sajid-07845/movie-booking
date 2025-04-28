package com.example.mtbs.service;

import com.example.mtbs.dto.ScreenRequest;
import com.example.mtbs.dto.ScreenResponse;
import jakarta.validation.Valid;

public interface ScreenService
{

    ScreenResponse addScreen(String theaterId, @Valid ScreenRequest screenRequest);

    ScreenResponse findScreen(String theaterId, String screenId);
}
