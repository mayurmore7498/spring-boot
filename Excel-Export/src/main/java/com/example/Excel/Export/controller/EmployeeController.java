package com.example.Excel.Export.controller;

import java.io.ByteArrayInputStream;
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Excel.Export.model.Employee;
import com.example.Excel.Export.repository.EmployeeRepository;
import com.example.Excel.Export.service.ExcelService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private ExcelService service;
	
	 @GetMapping("/export")
	    public ResponseEntity<InputStreamResource> exportExcel() {

	        List<Employee> employees = repository.findAll();
	        ByteArrayInputStream excel = ExcelService.exportToExcel(employees);

	        HttpHeaders headers = new HttpHeaders(null);
	        headers.add("Content-Disposition", "attachment; filename=employees.xlsx");

	        return ResponseEntity.ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(new InputStreamResource(excel));
	    }
}