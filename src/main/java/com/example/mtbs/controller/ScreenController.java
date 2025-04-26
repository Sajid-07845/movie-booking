package com.example.mtbs.controller;

import com.example.mtbs.dto.ScreenRequest;
import com.example.mtbs.dto.ScreenResponse;
import com.example.mtbs.service.ScreenService;
import com.example.mtbs.utililty.ResponseStructure;
import com.example.mtbs.utililty.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ScreenController
{
    private final ScreenService screenService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("theaters/{theaterId}/screens")
    public ResponseEntity<ResponseStructure<ScreenResponse>> addScreen (
            @PathVariable String theaterId, @RequestBody @Valid ScreenRequest screenRequest)
    {
            ScreenResponse screenResponse=screenService.addScreen(theaterId,screenRequest);
            return restResponseBuilder.success(HttpStatus.CREATED,"Screen added sucessfully",screenResponse);
    }
}
