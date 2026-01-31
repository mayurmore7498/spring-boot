package com.example.validation_project.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation_project.model.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
public User saveUser(@Valid @RequestBody User user) {
	return user;
}
}
