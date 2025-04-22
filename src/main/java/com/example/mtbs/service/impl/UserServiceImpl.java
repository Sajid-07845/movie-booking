package com.example.mtbs.service.impl;

import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.exception.UserExistByEmailException;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Override
    public UserDetails addUser(UserDetails userDetails)
    {
        boolean exists =userRepository.existsByEmail(userDetails.getEmail());
        if(exists)
        {
            throw new UserExistByEmailException("User already exist with this gmail");
        }
        UserDetails newUser;

        switch (userDetails.getUserRole())
        {
            case USER -> newUser = new User();
            case THEATER_OWNER -> newUser = new TheaterOwner();
            default -> throw new IllegalArgumentException("Unsupported role: " + userDetails.getUserRole());
        }


        return copyUserDetails(newUser, userDetails);
    }

    private UserDetails copyUserDetails(UserDetails user, UserDetails source)
    {
        user.setUserRole(source.getUserRole());
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());
        user.setCreatedAt(source.getCreatedAt());
        user.setDateOfBirth(source.getDateOfBirth());
        user.setPhoneNumber(source.getPhoneNumber());
        user.setUsername(source.getUsername());
        user.setUpdatedAt(source.getUpdatedAt());

        return userRepository.save(user);

        }
    }

