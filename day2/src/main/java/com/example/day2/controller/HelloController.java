package com.example.day2.controller;

import com.example.day2.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/hello")
    public String hello() {
        return messageService.getWelcomeMessage();
    }

    @GetMapping("/info")
    public String info() {
        return "This is Day 2 program uploaded on GitHub!";
    }
}
