package com.example.curd.day4.service;

import com.example.curd.day4.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    private int idCounter = 1;

   
    public Student addStudent(Student s) {
        s.setId(idCounter++);
        students.add(s);
        return s;
    }

   
    public List<Student> getAllStudents() {
        return students;
    }

   
    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

  
    public Student updateStudent(int id, Student newData) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newData.getName());
                s.setEmail(newData.getEmail());
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}
