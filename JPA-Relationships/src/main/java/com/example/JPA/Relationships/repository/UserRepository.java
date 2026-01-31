package com.example.JPA.Relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPA.Relationships.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
