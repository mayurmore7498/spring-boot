package com.example.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pagination.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
