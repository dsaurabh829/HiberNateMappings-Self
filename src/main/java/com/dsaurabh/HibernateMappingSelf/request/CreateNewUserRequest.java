package com.dsaurabh.HibernateMappingSelf.request;

import com.dsaurabh.HibernateMappingSelf.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateNewUserRequest {

    @NotNull
    private String userName;
    @Email
    private String userEmail;

    public User toUser(){
        return User.builder()
                .email(userEmail)
                .name(userName).build();
    }

}
