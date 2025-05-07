package com.example.mtbs.service;

import com.example.mtbs.dto.ShowResponse;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public interface ShowService
{


     ShowResponse addShow(String theaterId, String screenId, String movieId, @NotNull Long startTime);
}
