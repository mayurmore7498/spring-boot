package com.example.day6.service;

import com.example.day6.exception.StudentNotFoundException;
import com.example.day6.model.Student;
import com.example.day6.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student save(Student s) {
        return repository.save(s);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id " + id)
                );
    }

    public Student update(int id, Student newData) {
        Student s = getById(id);
        s.setName(newData.getName());
        s.setEmail(newData.getEmail());
        return repository.save(s);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
