package com.example.SpringSecEx.service;

import com.example.SpringSecEx.model.Users;
import com.example.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    public Users register(Users user)
    {
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(user.getUsername());
        }

        return "Fail";
    }
}
