package com.example.mtbs.controller;

import com.example.mtbs.dto.UserRegistrationRequset;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.service.UserService;
import com.example.mtbs.utililty.ResponseStructure;
import com.example.mtbs.utililty.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController
{
    private final UserService userService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserDetails>> addUser(@RequestBody UserRegistrationRequset user)
    {
        UserDetails userDetails=userService.addUser(user);
        return  restResponseBuilder.success(HttpStatus.CREATED," User Registed sucessfully",userDetails);

    }
}
