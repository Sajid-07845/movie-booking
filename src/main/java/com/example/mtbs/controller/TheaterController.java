package com.example.mtbs.controller;

import com.example.mtbs.dto.TheatorRequest;
import com.example.mtbs.dto.TheatorResponse;
import com.example.mtbs.service.TheaterService;
import com.example.mtbs.utililty.ResponseStructure;
import com.example.mtbs.utililty.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TheaterController
{
    private final TheaterService theaterService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/theators")
    public ResponseEntity<ResponseStructure<TheatorResponse>> addTheater(
            @Valid @RequestParam String email, @RequestBody TheatorRequest theatorRequest)
    {
            TheatorResponse response =theaterService.addTheator(email, theatorRequest);
            return restResponseBuilder.success(HttpStatus.OK,"User added sucessfully",response);
    }

    @GetMapping("/theators/{theaterId}")
    public ResponseEntity<ResponseStructure<TheatorResponse>> findTheatorById(@PathVariable String theaterId)
    {
        TheatorResponse theaterResponse=theaterService.findTheaterById(theaterId);
        return restResponseBuilder.success(HttpStatus.FOUND,"Theator details found",theaterResponse);
    }

    @PutMapping("/theaters/{theaterId}")
    public ResponseEntity<ResponseStructure<TheatorResponse>> updateTheaterById(@PathVariable String theaterId, @Valid @RequestBody TheatorRequest theatorRequest )
    {
        TheatorResponse theatorResponse=theaterService.updateTheater(theaterId,theatorRequest);
        return restResponseBuilder.success(HttpStatus.OK,"Theator Details Updated",theatorResponse);
    }

}
