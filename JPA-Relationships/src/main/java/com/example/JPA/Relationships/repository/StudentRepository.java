package com.example.JPA.Relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPA.Relationships.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
