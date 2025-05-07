package com.example.mtbs.controller;

import com.example.mtbs.dto.ShowResponse;
import com.example.mtbs.service.ShowService;
import com.example.mtbs.utililty.ResponseStructure;
import com.example.mtbs.utililty.RestResponseBuilder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@AllArgsConstructor
public class ShowController
{
    private final ShowService showService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("theaters/{theaterId}/screens/{screenId}/shows")
    @PreAuthorize("hasAuthority('THEATER_OWNER')")
    public ResponseEntity<ResponseStructure<ShowResponse>> addShow( @PathVariable String theaterId, @PathVariable String screenId, @RequestParam String movieId , @RequestParam @NotNull Long startTime ){
        ShowResponse showResponse = showService.addShow(theaterId, screenId, movieId, startTime);
        return restResponseBuilder.success(HttpStatus.OK, "Show sucessfully created", showResponse);
    }

}
