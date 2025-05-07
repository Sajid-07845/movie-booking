package com.example.mtbs.mapper;

import com.example.mtbs.dto.FeedbackResponse;
import com.example.mtbs.entity.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper
{

    public FeedbackResponse todto(Feedback feedback)
    {
        if(feedback == null)
        {
            return null;
        }
     return new FeedbackResponse(
             feedback.getFeedbackId(),
             feedback.getRating(),
             feedback.getReview());
    }
}
