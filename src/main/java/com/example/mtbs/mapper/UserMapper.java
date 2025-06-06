package com.example.mtbs.mapper;

import com.example.mtbs.dto.UserRegistrationRequset;
import com.example.mtbs.dto.UserResponse;
import com.example.mtbs.entity.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper
{
    private final PasswordEncoder passwordEncoder;

    public UserResponse toUserResponse(UserDetails userDetails)
    {

       return new UserResponse(
        userDetails.getUsername(),
        userDetails.getEmail(),
        userDetails.getPhoneNumber(),
        userDetails.getUserRole(),
        userDetails.getDateOfBirth()
        );

    }

    public UserDetails toEntity(UserDetails user, UserRegistrationRequset source)
    {
        user.setUserRole(source.userRole());
        user.setEmail(source.email());
        user.setPassword(passwordEncoder.encode(source.password()));
        user.setDateOfBirth(source.dateOfBirth());
        user.setPhoneNumber(source.phoneNumber());
        user.setUsername(source.username());

        return  user;
    }

    public UserResponse userDetailsResponseMapper(UserDetails user)
    {
        if(user==null)
        {
            return null;
        }
        return new UserResponse(
            user.getUsername(),
            user.getEmail(),
            user.getPhoneNumber(),
            user.getUserRole(),
            user. getDateOfBirth()
        );
    }
}
