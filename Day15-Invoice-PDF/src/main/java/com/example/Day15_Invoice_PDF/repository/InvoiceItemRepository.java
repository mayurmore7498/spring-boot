package com.example.Day15_Invoice_PDF.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Day15_Invoice_PDF.model.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem , Long> {
	
	List<InvoiceItem> findByInvoiceId(Long invoiceId);

}
