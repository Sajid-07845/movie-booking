package com.example.mtbs.mapper;

import com.example.mtbs.dto.ShowResponse;
import com.example.mtbs.entity.Movie;
import com.example.mtbs.entity.Screen;
import com.example.mtbs.entity.Show;
import com.example.mtbs.entity.Theater;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
public class ShowMapper
{


    public ShowResponse toDto(Show saved)
    {
        if(saved == null)
            return null;
        return new ShowResponse(
                saved.getShowId(),
                saved.getStartsAt(),
                saved.getEndsAt()
        );


    }


//    public Show toEntity(Show show, Long startTime, Screen screen, Movie movie)
//    {
//        show.setScreen(screen);
//        show.setMovie(movie);
//        Instant instantStartTime = Instant.ofEpochMilli(startTime);
//        show.setStartsAt(instantStartTime);
//        Duration runtime = movie.getRuntime();
//        Instant instantEndTime = instantStartTime.plus(runtime);
//        show.setEndsAt(instantEndTime);
//        return show;
//
//        show.setScreen(screen);
//        show.setMovie(movie);
//        Instant instantStartTime = Instant.ofEpochMilli(startTime);
//        show.setStartsAt(instantStartTime);
//        Instant endTime = instantStartTime.plus(movie.getRuntime());
//        System.out.println(endTime);
//        show.setEndsAt(endTime);
//        return show;
//    }
}
