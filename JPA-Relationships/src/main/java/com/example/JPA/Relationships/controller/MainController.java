package com.example.JPA.Relationships.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.JPA.Relationships.model.Customer;
import com.example.JPA.Relationships.model.Student;
import com.example.JPA.Relationships.model.User;
import com.example.JPA.Relationships.repository.CustomerRepository;
import com.example.JPA.Relationships.repository.StudentRepository;
import com.example.JPA.Relationships.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private StudentRepository studentRepo;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }
}
