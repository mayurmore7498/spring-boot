package com.example.day7.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "JWT Authentication Successful ✅";
    }
}
