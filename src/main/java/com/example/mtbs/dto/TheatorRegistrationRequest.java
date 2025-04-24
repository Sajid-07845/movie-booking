package com.example.mtbs.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TheatorRegistrationRequest(
        @NotNull
        @Size(min = 1,max = 20,message = "username cannot be null")
        String name,

        @NotNull
        @Size(min=1,max = 50,message = "address cannot be null")
        String address,

        @NotNull
        @Size(min = 1,max = 50,message = "city cannot be null")
        String city,

        @NotNull
        @Size(min = 1,max = 30,message = "landmark cannot be null")
        String landmark
)
{
}
