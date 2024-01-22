package com.mateusnere.example.infrastructure.controllers;

public record CreateUserRequest(String username, String password, String email) {
}
