package com.example.mtbs.dto;

import lombok.Builder;

@Builder
public record TheatorResponse(
        String theatorId,
        String name,
        String address,
        String landmark,
        String city
)
{
}
