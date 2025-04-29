package com.example.mtbs.security;

import com.example.mtbs.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService
{
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
         com.example.mtbs.entity.UserDetails details =userRepository.findByEmail(username);
         if(details == null)
         {
             throw new UsernameNotFoundException(" user does not exist by this email");
         }
        // here we are returning a user object of spring security
        return User.builder()
                .username(details.getEmail())
                .password(details.getPassword())
                .authorities(details.getUserRole().name())
                .build();
    }


}
