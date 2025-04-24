package com.example.mtbs.service.impl;

import com.example.mtbs.dto.TheatorRegistrationRequest;
import com.example.mtbs.dto.TheatorResponse;
import com.example.mtbs.entity.Theater;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.enums.UserRole;
import com.example.mtbs.exception.UserNotFoundException;
import com.example.mtbs.mapper.TheatorMapper;
import com.example.mtbs.repository.TheatorRepository;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.TheaterService;
import com.example.mtbs.utililty.ResponseStructure;
import com.example.mtbs.utililty.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService
{
    private final TheatorRepository theatorRepository;
    private final UserRepository userRepository;
    private final TheatorMapper theatorMapper;

    @Override
    public TheatorResponse addTheator(String email, TheatorRegistrationRequest theaterRegistrationRequest)
    {
        if(userRepository.existsByEmail(email) && userRepository.findByEmail(email).getUserRole()== UserRole.THEATER_OWNER)
        {
            UserDetails details=userRepository.findByEmail(email);
            Theater theater1 =copy(theaterRegistrationRequest, new Theater(),details);
            return theatorMapper.theater(theater1);
        }
       throw new UserNotFoundException("user not Found by this email");
    }

    private Theater copy(TheatorRegistrationRequest theatorRegistrationRequest,Theater theater,UserDetails userDetails)
    {
        theater.setAddress(theatorRegistrationRequest.address());
        theater.setCity(theatorRegistrationRequest.city());
        theater.setName(theatorRegistrationRequest.name());
        theater.setLandmark(theatorRegistrationRequest.landmark());
        theater.setTheaterOwner((TheaterOwner) userDetails);
        theatorRepository.save(theater);
        return theater;
    }
}
