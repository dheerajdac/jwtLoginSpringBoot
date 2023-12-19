package com.dheerajdac.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dheerajdac.app.entity.User;
import com.dheerajdac.app.repository.UserRepo;

@RestController
public class HelloController {

    @Autowired
    UserRepo userRepo;
    
    @GetMapping("/")
    public String get() {
        return "hello world";
    }

    @GetMapping("/all")
    public Iterable<User> getAll() {
        return userRepo.findAll();
    }
}
