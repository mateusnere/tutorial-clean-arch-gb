package com.mateusnere.example.repository;

import com.mateusnere.example.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
