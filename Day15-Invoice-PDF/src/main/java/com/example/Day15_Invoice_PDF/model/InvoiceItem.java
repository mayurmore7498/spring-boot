package com.example.Day15_Invoice_PDF.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class InvoiceItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String product;
	
	private Integer quantity;
	
	private Double price;
	
	@ManyToOne
	private Invoice invoice;
	
	

}
