package com.example.JPA.Relationships.model;

import jakarta.persistence.*;

@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	private String phone;
	
	
	

}
