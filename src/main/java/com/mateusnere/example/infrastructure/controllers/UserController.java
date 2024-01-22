package com.mateusnere.example.infrastructure.controllers;

import com.mateusnere.example.application.usecases.CreateUserInteractor;
import com.mateusnere.example.domain.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final CreateUserInteractor createUserInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserInteractor, UserDTOMapper userDTOMapper) {
        this.createUserInteractor = createUserInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    CreateUserResponse create(@RequestBody CreateUserRequest request) {
        User userBusinessObj = userDTOMapper.toUser(request);
        User savedBusinessObj = createUserInteractor.createUser(userBusinessObj);
        return userDTOMapper.toResponse(savedBusinessObj);
    }
}
