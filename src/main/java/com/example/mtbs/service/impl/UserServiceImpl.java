package com.example.mtbs.service.impl;

import com.example.mtbs.dto.UserRegistrationRequset;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.exception.UserExistByEmailException;
import com.example.mtbs.mapper.UserMapper;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails addUser(UserRegistrationRequset userRegistrationRequset)
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
        return userRepository.save(user);
    }

}

