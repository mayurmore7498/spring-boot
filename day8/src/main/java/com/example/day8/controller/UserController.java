package com.example.day8.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public String user() {
        return "Welcome USER 👤";
    }
}
