package com.example.Day15_Invoice_PDF.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Day15_Invoice_PDF.service.InvoicePdfService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoicePdfService service;
	
	public ResponseEntity<InputStreamResource> downloadInvoice(@PathVariable Long id){
		
		ByteArrayInputStream pdf=service.generateInvoice(id);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=invoice_"+id+".pdf" )
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
		
	}
	

}
