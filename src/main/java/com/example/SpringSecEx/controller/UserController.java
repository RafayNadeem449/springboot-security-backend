package com.example.SpringSecEx.controller;

import com.example.SpringSecEx.model.Users;
import com.example.SpringSecEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public Users register(@RequestBody Users user)
    {
        return service.register(user);
    }
}
