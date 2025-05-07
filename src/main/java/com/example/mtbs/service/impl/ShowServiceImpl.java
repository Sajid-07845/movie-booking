package com.example.mtbs.service.impl;

import com.example.mtbs.dto.ShowResponse;
import com.example.mtbs.entity.Movie;
import com.example.mtbs.entity.Screen;
import com.example.mtbs.entity.Show;
import com.example.mtbs.entity.Theater;
import com.example.mtbs.exception.MovieNotFoundByIdException;
import com.example.mtbs.exception.ScreenNotFoundByIdException;
import com.example.mtbs.exception.ShowsConflictException;
import com.example.mtbs.exception.TheaterNotFoundByIdException;
import com.example.mtbs.mapper.ShowMapper;
import com.example.mtbs.repository.MovieRepository;
import com.example.mtbs.repository.ScreenRepository;
import com.example.mtbs.repository.ShowRepository;
import com.example.mtbs.repository.TheatorRepository;
import com.example.mtbs.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService
{
    private final TheatorRepository theatorRepository;
    private final ScreenRepository screenRepository;
    private final MovieRepository movieRepository;
    private final ShowRepository showRepository;
    private final ShowMapper showMapper;


    @Override
    public ShowResponse addShow(String theaterId, String screenId, String movieId, Long startTime)
    {

       Optional<Theater> theater = theatorRepository.findById(theaterId);
       if(theater.isEmpty())
       {
           throw new TheaterNotFoundByIdException("no theater found by this id");
       }
        Theater theater1=theater.get();

        Movie movie= movieRepository.findById(movieId).orElseThrow(
              ()-> new MovieNotFoundByIdException("NO movie found by this id"));

        Screen screen= screenRepository.findById(screenId).orElseThrow(
              ()-> new ScreenNotFoundByIdException("no screen present by this id"));

         List<Show> shows = screen.getShows();
            Instant instantStartTime =Instant.ofEpochMilli(startTime);

            for(Show s:shows)
            {
                Instant showstartTime = s.getStartsAt();
                Instant endTime = s.getEndsAt();
                Instant movieCompliltion = instantStartTime.plus(movie.getRuntime());

                if(!(movieCompliltion.isBefore(showstartTime) || instantStartTime.isAfter(endTime) ))
                 {
                throw new ShowsConflictException(" show is already allocated");
                 }
             }

            Show show =copy(new Show(),startTime,screen,movie);
            return showMapper.toDto(show);
    }


    private Show copy(Show show, Long startTime, Screen screen, Movie movie) {
        // Set the screen and movie on the show object
        show.setScreen(screen);
        show.setMovie(movie);

        // Convert startTime from milliseconds to Instant
        Instant instantStartTime = Instant.ofEpochMilli(startTime);
        show.setStartsAt(instantStartTime);

        // Get the movie runtime as Duration
        Duration runtime = Duration.ofMinutes(movie.getRuntime().toNanos());

        // If the movie runtime is invalid, throw an exception
        if (runtime == null || runtime.isZero() || runtime.isNegative()) {
            throw new IllegalArgumentException("Invalid movie runtime: " + runtime);
        }

        // Add the movie runtime (Duration) to the start time to calculate the end time
        Instant endTime = instantStartTime.plus(runtime);

        // Debugging logs to check values
        System.out.println("Start time: " + instantStartTime);
        System.out.println("Movie Runtime: " + runtime);
        System.out.println("End time: " + endTime);

        // Set the end time for the show
        show.setEndsAt(endTime);

        // Save the show to the repository
        showRepository.save(show);

        return show;
    }
}
