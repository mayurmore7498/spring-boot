package com.example.JPA.Relationships.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String courseName;
	
	@ManyToMany(mappedBy="courses")
	private List<Student>students;
}

