package com.mateusnere.example.infrastructure.gateways;

import com.mateusnere.example.application.gateways.UserGateway;
import com.mateusnere.example.domain.entity.User;
import com.mateusnere.example.infrastructure.persistence.UserEntity;
import com.mateusnere.example.infrastructure.persistence.UserRepository;

public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }
    @Override
    public User createUser(User userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        UserEntity savedObj = userRepository.save(userEntity);
        return userEntityMapper.toDomainObject(savedObj);
    }
}
