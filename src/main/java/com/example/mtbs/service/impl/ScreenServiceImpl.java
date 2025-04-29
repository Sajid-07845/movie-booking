package com.example.mtbs.service.impl;

import com.example.mtbs.dto.ScreenRequest;
import com.example.mtbs.dto.ScreenResponse;
import com.example.mtbs.entity.Screen;
import com.example.mtbs.entity.Seat;
import com.example.mtbs.entity.Theater;
import com.example.mtbs.exception.ScreenNotFoundByIdException;
import com.example.mtbs.exception.TheaterNotFoundByIdException;
import com.example.mtbs.mapper.ScreenMapper;
import com.example.mtbs.repository.ScreenRepository;
import com.example.mtbs.repository.SeatRepository;
import com.example.mtbs.repository.TheatorRepository;
import com.example.mtbs.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService
{
    private final ScreenRepository screenRepository;
    private final TheatorRepository theatorRepository;
    private final ScreenMapper screenMapper;
    private final SeatRepository seatRepository;

    @Override
    public ScreenResponse addScreen(String theaterId, ScreenRequest screenRequest)
    {
        Optional<Theater> theater =theatorRepository.findById(theaterId);
        if(theater.isEmpty())
        {
           throw new TheaterNotFoundByIdException("Theator not found with this id");
        }
        Theater theater1 =theater.get();
        Screen screen =copy1(screenRequest,theater1,new Screen());
        return screenMapper.toResponseScreen(screen);
    }


    private Screen copy1(ScreenRequest screenRequest, Theater theater1, Screen screen)
    {
        screen.setScreenType(screenRequest.screenType());
        screen.setCapacity(screenRequest.capacity());
        screen.setNoOfRows(screenRequest.noOfRows());
        screen.setTheater(theater1);
        screenRepository.save(screen);
        screen.setSeats(createSeats(screen,screenRequest.capacity()));
        return screen;
    }

    private List<Seat> createSeats(Screen screen, Integer capacity)
    {
        List<Seat> seat = new LinkedList<>();
        int noOfRows = screen.getCapacity() / screen.getNoOfRows();
        for (int i = 65; i <= 65 + screen.getNoOfRows(); i++)
        {
            char row = (char) i;
            for (int j = 1; i <= noOfRows; j++)
            {
                Seat seats = new Seat();
                seats.setScreen(screen);
                seatRepository.save(seats);
                seat.add(seats);
            }
        }

        return seat;
    }

    @Override
    public ScreenResponse findScreen(String theaterId, String screenId)
    {
       Optional<Theater> theater =theatorRepository.findById(theaterId);
       if(theater.isEmpty())
       {
           throw new TheaterNotFoundByIdException("No theater Present by this Id");
       }
       else
       {
           Theater theater1=theater.get();
           Optional<Screen> screen = screenRepository.findById(screenId);
           if (screen.isEmpty()) {
               throw new ScreenNotFoundByIdException("No Screen Found by that Id:");
           }
           else
           {
               Screen screen1=screen.get();
               return screenMapper.toResponseScreen(screen1);
           }
       }
    }
}
