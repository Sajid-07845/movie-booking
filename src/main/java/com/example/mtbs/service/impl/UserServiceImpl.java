package com.example.mtbs.service.impl;

import com.example.mtbs.dto.UserRegistrationRequset;
import com.example.mtbs.dto.UserRequest;
import com.example.mtbs.dto.UserResponse;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.exception.UserExistByEmailException;
import com.example.mtbs.exception.UserNotFoundException;
import com.example.mtbs.mapper.UserMapper;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse addUser(UserRegistrationRequset userRegistrationRequset)
    {
        boolean exists =userRepository.existsByEmail(userRegistrationRequset.email());
        if(exists)
        {
            throw new UserExistByEmailException("User already exist with this gmail");
        }
        UserDetails newUser;
        switch (userRegistrationRequset.userRole())
        {
            case USER -> newUser = new User();
            case THEATER_OWNER -> newUser = new TheaterOwner();
            default -> throw new IllegalArgumentException("Unsupported role: " + userRegistrationRequset.username());
        }
            UserDetails user = userMapper.toEntity(newUser, userRegistrationRequset);

            userRepository.save(user);
            return userMapper.toUserResponse(user);
    }


    @Override
    public UserRequest updateUserProfile(String email, UserRequest userRequest)
    {
        UserDetails details=userRepository.findByEmail(email);
        if(details==null)
        {
            throw new UserNotFoundException("User with this email is not exist");
        }
        if(userRequest.username()!=null)
        {
            details.setUsername(userRequest.username());
        }
        if(userRequest.phoneNumber()!=null)
        {
            details.setPhoneNumber(userRequest.phoneNumber());
        }
        if(userRequest.dateOfBirth()!=null)
        {
            details.setDateOfBirth(userRequest.dateOfBirth());
        }
        userRepository.save(details);

        return userRequest;
    }

    @Override
    public UserResponse softDelete(String email)
    {
//        boolean exists=userRepository.existsByEmail(email);
//        if(exists)
//        {
//            UserDetails user=userRepository.findByEmail(email);
//            user.setDeleted(true);
//            user.setDeletedAt(Instant.now());
//            userRepository.save(user);
//            return userMapper.userDetailsResponseMapper(user);
//        }
//        throw new UserNotFoundException("No user Found with this email");

        UserDetails user=userRepository.findByEmail(email);
        if(user==null)
        {
            throw new UserNotFoundException("No user Found with this email");
        }
        user.setDeleted(true);
        user.setDeletedAt(Instant.now());
        userRepository.save(user);
        return userMapper.userDetailsResponseMapper(user);
    }

}

