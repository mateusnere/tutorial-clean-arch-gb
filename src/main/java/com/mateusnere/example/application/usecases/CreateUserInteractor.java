package com.mateusnere.example.application.usecases;

import com.mateusnere.example.application.gateways.UserGateway;
import com.mateusnere.example.domain.entity.User;

public class CreateUserInteractor {

    private final UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        return userGateway.createUser(user);
    }
}
