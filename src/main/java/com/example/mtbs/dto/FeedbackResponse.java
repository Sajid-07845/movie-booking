package com.example.mtbs.dto;


public record FeedbackResponse(
        String feedbackId,
        int rating,
        String review
)
{
}
