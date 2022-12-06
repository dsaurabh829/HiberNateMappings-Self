package com.dsaurabh.HibernateMappingSelf.service;

import com.dsaurabh.HibernateMappingSelf.entity.User;
import com.dsaurabh.HibernateMappingSelf.repository.UserRepository;
import com.dsaurabh.HibernateMappingSelf.request.CreateNewUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository repository;

    public User addNewUser(CreateNewUserRequest request){
        Optional<User> existingUser = repository.findByEmail(request.getUserEmail());
        if(existingUser.isPresent())
            throw new RuntimeException("User already present");
        User user =  saveOrUpdate(request.toUser());
        log.info(user.toString());
        return user;
    }

    public User saveOrUpdate(User toUser) {
        return repository.save(toUser);
    }

    public User getUserById(String userId) {
        Optional<User> existingUser = repository.findById(UUID.fromString(userId));
        if(existingUser.isEmpty())
            throw new RuntimeException("User Not found");
        return existingUser.get();
    }
}
