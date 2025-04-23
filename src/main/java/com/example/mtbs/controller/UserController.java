package com.example.mtbs.controller;

import com.example.mtbs.dto.UserRegistrationRequset;
import com.example.mtbs.dto.UserRequest;
import com.example.mtbs.dto.UserResponse;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.mapper.UserMapper;
import com.example.mtbs.service.UserService;
import com.example.mtbs.utililty.ResponseStructure;
import com.example.mtbs.utililty.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController
{
    private final UserService userService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRegistrationRequset user)
    {
        UserResponse response=userService.addUser(user);
        return  restResponseBuilder.success(HttpStatus.CREATED," User Registed sucessfully",response);

    }
    @PutMapping("/users/profile")
    public ResponseEntity<ResponseStructure<UserRequest>> updateUserProfile(
            @RequestParam String email,
            @RequestBody UserRequest userRequest)
    {
        UserRequest userDetails=userService.updateUserProfile( email, userRequest);
        return restResponseBuilder.success(HttpStatus.CREATED,"User Updated Successfully",userDetails);
    }
}