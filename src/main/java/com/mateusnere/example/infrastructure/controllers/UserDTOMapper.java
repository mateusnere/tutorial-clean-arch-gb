package com.mateusnere.example.infrastructure.controllers;

import com.mateusnere.example.domain.entity.User;

public class UserDTOMapper {

    CreateUserResponse toResponse(User user) {
        return new CreateUserResponse(user.username(), user.email());
    }

    User toUser(CreateUserRequest request) {
        return new User(request.username(), request.password(), request.email());
    }
}
