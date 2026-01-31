package com.example.JPA.Relationships.model;

import jakarta.persistence.*;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="profile_id")
	private Profile profile;

}
