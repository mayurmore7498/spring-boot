package com.example.day7.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day7.model.User;

public interface  UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String Username);

	
}
