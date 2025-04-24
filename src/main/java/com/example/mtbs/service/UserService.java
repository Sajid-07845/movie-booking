package com.example.mtbs.service;

import com.example.mtbs.dto.UserRegistrationRequset;
import com.example.mtbs.dto.UserRequest;
import com.example.mtbs.dto.UserResponse;

public interface UserService
{

    UserResponse addUser(UserRegistrationRequset userRegistrationRequset);

   UserRequest updateUserProfile(String email, UserRequest userRequest);

    UserResponse softDelete(String email);
}
