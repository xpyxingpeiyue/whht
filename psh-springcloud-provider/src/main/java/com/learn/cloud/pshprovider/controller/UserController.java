package com.learn.cloud.pshprovider.controller;

import com.learn.cloud.pshprovider.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public Object list(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }
}
