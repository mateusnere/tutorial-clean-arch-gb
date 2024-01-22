package com.mateusnere.example.main;

import com.mateusnere.example.application.gateways.UserGateway;
import com.mateusnere.example.application.usecases.CreateUserInteractor;
import com.mateusnere.example.infrastructure.controllers.UserDTOMapper;
import com.mateusnere.example.infrastructure.gateways.UserEntityMapper;
import com.mateusnere.example.infrastructure.gateways.UserRepositoryGateway;
import com.mateusnere.example.infrastructure.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUserInteractor createUserCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}
