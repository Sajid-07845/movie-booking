package com.example.mtbs.mapper;

import com.example.mtbs.dto.UserRegistrationRequset;
import com.example.mtbs.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapper
{
    public UserDetails toEntity(UserDetails user, UserRegistrationRequset source)
    {
        user.setUserRole(source.userRole());
        user.setEmail(source.email());
        user.setPassword(source.password());
        user.setDateOfBirth(source.dateOfBirth());
        user.setPhoneNumber(source.phoneNumber());
        user.setUsername(source.username());

        return  user;
    }
}
