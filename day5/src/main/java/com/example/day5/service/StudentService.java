package com.example.day5.service;

import com.example.day5.model.Student;
import com.example.day5.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student newData) {
        return repo.findById(id)
                .map(student -> {
                    student.setName(newData.getName());
                    student.setEmail(newData.getEmail());
                    return repo.save(student);
                })
                .orElse(null);
    }

    public String deleteStudent(int id) {
        repo.deleteById(id);
        return "Student deleted";
    }
}
