package com.example.mtbs.dto;

import java.time.Instant;

public record ShowResponse (
        String showId,
        Instant startsAt,
        Instant endsAt
){
}
