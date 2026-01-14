package com.example.day3.service;

import com.example.day3.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student saveStudent(Student s) {
        
        s.setId(1);
        return s;
    }
}
