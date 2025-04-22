package com.example.mtbs.service;

import com.example.mtbs.dto.UserRegistrationRequset;
import com.example.mtbs.entity.UserDetails;

public interface UserService
{

    UserDetails addUser(UserRegistrationRequset userRegistrationRequset);
}
