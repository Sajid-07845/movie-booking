package com.example.mtbs.service;

import com.example.mtbs.dto.FeedbackRequest;
import com.example.mtbs.dto.FeedbackResponse;

public interface FeedbackService {
    FeedbackResponse addFeedback(String userId, String movieId,FeedbackRequest feedbackRequest);
}
