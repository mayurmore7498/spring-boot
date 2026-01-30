package com.example.Day15_Invoice_PDF.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Day15_Invoice_PDF.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice , Long>{

}
