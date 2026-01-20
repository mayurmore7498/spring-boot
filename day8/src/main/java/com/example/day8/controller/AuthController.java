package com.example.day8.controller;

import com.example.day8.dto.*;
import com.example.day8.model.User;
import com.example.day8.repository.UserRepository;
import com.example.day8.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setRole(req.getRole());

        repo.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {

        User user = repo.findByUsername(req.getUsername())
                .orElseThrow();

        if (encoder.matches(req.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(
                    user.getUsername(),
                    user.getRole());
        }

        return "Invalid credentials";
    }
}
