package com.example.mtbs.service.impl;

import com.example.mtbs.dto.TheatorRequest;
import com.example.mtbs.dto.TheatorResponse;
import com.example.mtbs.entity.Theater;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.enums.UserRole;
import com.example.mtbs.exception.TheaterNotFoundByIdException;
import com.example.mtbs.exception.UserNotFoundException;
import com.example.mtbs.mapper.TheatorMapper;
import com.example.mtbs.repository.TheatorRepository;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.TheaterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService
{
    private final TheatorRepository theatorRepository;
    private final UserRepository userRepository;
    private final TheatorMapper theatorMapper;

    @Override
    public TheatorResponse addTheator(String email, TheatorRequest theatorRequest)
    {
        if(userRepository.existsByEmail(email) && userRepository.findByEmail(email).getUserRole()== UserRole.THEATER_OWNER)
        {
            UserDetails details=userRepository.findByEmail(email);
            Theater theater1 =copy(theatorRequest, new Theater(),details);
            return theatorMapper.theater(theater1);
        }
       throw new UserNotFoundException("user not Found by this email");
    }

    private Theater copy(TheatorRequest theatorRequest,Theater theater,UserDetails userDetails)
    {
        theater.setAddress(theatorRequest.address());
        theater.setCity(theatorRequest.city());
        theater.setName(theatorRequest.name());
        theater.setLandmark(theatorRequest.landmark());
        theater.setTheaterOwner((TheaterOwner) userDetails);
        theatorRepository.save(theater);
        return theater;
    }

    @Override
    public TheatorResponse findTheaterById(String theaterId)
    {
        Optional<Theater> theater =theatorRepository.findById(theaterId);
//        Theater theater1= theater.get();
//        if(theater1 == null)
//        {
//            throw new TheaterNotFoundByIdException("No theator found with this id");
//        }
        if(theater.isEmpty())
        {
            throw new TheaterNotFoundByIdException("No theator found with this id");
        }
        else
        {
            Theater theater1=theater.get();
            return theatorMapper.theatorResponseMapper(theater1);
        }
    }

    @Override
    public TheatorResponse updateTheater(String theaterId, TheatorRequest registerationRequest) {
        if(theatorRepository.existsById(theaterId)) {
            Theater theater = theatorRepository.findById(theaterId).get();
            theater = copy1(registerationRequest, theater);
            return theatorMapper.theatorResponseMapper(theater);
        }
        throw new TheaterNotFoundByIdException("Theater not found by id");
    }

    private Theater copy1(TheatorRequest theatorRequest, Theater theater)
    {
        theater.setAddress(theatorRequest.address());
        theater.setCity(theatorRequest.city());
        theater.setName(theatorRequest.name());
        theater.setLandmark(theatorRequest.landmark());
        theatorRepository.save(theater);
        return theater;
    }
}
