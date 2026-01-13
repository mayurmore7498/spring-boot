package com.example.day2.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getWelcomeMessage() {
        return "Welcome to Day 2 Spring Boot Learning!";
    }
}
