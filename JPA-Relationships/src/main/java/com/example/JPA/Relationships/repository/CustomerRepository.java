package com.example.JPA.Relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPA.Relationships.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer ,Long>{

}
