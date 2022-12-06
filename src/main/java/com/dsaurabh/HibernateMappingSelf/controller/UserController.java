package com.dsaurabh.HibernateMappingSelf.controller;

import com.dsaurabh.HibernateMappingSelf.entity.User;
import com.dsaurabh.HibernateMappingSelf.request.CreateNewUserRequest;
import com.dsaurabh.HibernateMappingSelf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User addNewUser(@RequestBody CreateNewUserRequest request){
        return service.addNewUser(request);
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable(value = "id") String userId){
        return service.getUserById(userId);

    }
}

