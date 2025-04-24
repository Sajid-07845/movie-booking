package com.example.mtbs.controller;

import com.example.mtbs.dto.TheatorRegistrationRequest;
import com.example.mtbs.dto.TheatorResponse;
import com.example.mtbs.entity.Theater;
import com.example.mtbs.service.TheaterService;
import com.example.mtbs.utililty.ResponseStructure;
import com.example.mtbs.utililty.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TheaterController
{
    private final TheaterService theaterService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/theators")
    public ResponseEntity<ResponseStructure<TheatorResponse>> addTheater(
            @Valid @RequestParam String email, @RequestBody TheatorRegistrationRequest theatorRegistrationRequest)
    {
            TheatorResponse response =theaterService.addTheator(email, theatorRegistrationRequest);
            return restResponseBuilder.success(HttpStatus.OK,"User added sucessfully",response);
    }
}
