package com.example.mtbs.service.impl;

import com.example.mtbs.dto.FeedbackRequest;
import com.example.mtbs.dto.FeedbackResponse;
import com.example.mtbs.entity.Feedback;
import com.example.mtbs.entity.Movie;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.exception.MovieNotFoundByIdException;
import com.example.mtbs.exception.UserNotFoundException;
import com.example.mtbs.mapper.FeedbackMapper;
import com.example.mtbs.repository.FeedbackRepository;
import com.example.mtbs.repository.MovieRepository;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final FeedbackMapper feedbackMapper;

    @Override
    public FeedbackResponse addFeedback(String userId, String movieId, FeedbackRequest feedbackRequest) {
        UserDetails user=userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("user not found by that id"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundByIdException("No movie found by this id"));

        Feedback feedback = copy(feedbackRequest, new Feedback(), movie, user);
        return feedbackMapper.todto(feedback);
    }

    private Feedback copy(FeedbackRequest feedbackRequest, Feedback feedback, Movie movie, UserDetails user) {
        feedback.setRating(feedbackRequest.rating());
        feedback.setReview(feedbackRequest.review());
        feedback.setMovies(movie);
        feedback.setUser((User) user);
        feedbackRepository.save(feedback);
        return feedback;
    }
}