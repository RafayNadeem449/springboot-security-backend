package com.example.SpringSecEx.service;

import com.example.SpringSecEx.model.Users;
import com.example.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private UserRepo userRepo;

    public Users register(Users user)
    {
        return userRepo.save(user);
    }

}
