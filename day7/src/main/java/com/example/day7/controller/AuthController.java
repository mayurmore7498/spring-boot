package com.example.day7.controller;

import com.example.day7.dto.*;
import com.example.day7.model.User;
import com.example.day7.repository.UserRepository;
import com.example.day7.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword()));
        repository.save(user);

        return "User Registered Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {

        User user = repository.findByUsername(req.getUsername())
                .orElseThrow();

        if (encoder.matches(req.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }

        return "Invalid username or password";
    }
}
