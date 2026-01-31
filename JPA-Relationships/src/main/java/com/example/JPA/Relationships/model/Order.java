package com.example.JPA.Relationships.model;

import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

