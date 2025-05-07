package com.example.mtbs.controller;

import com.example.mtbs.dto.FeedbackRequest;
import com.example.mtbs.dto.FeedbackResponse;
import com.example.mtbs.service.FeedbackService;
import com.example.mtbs.utililty.ResponseStructure;
import com.example.mtbs.utililty.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FeedbackController
{
    private final FeedbackService feedbackService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/users/{userId}/movies/{movieId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ResponseStructure<FeedbackResponse>> addFeedback (@PathVariable String userId,@PathVariable  String movieId, @RequestBody FeedbackRequest feedbackRequest)
    {
//            String email = SecurityContextHolder.getContext().getAuthentication().getName();
            FeedbackResponse response=feedbackService.addFeedback(userId,movieId,feedbackRequest );
            return restResponseBuilder.success(HttpStatus.CREATED,"Add feedBack sycessfully",response);
    }
}
