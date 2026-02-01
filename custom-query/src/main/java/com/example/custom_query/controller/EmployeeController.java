package com.example.custom_query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.custom_query.model.Employee;
import com.example.custom_query.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping("/save")
	public Employee Save(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@GetMapping("/department/{dept}")
	public List<Employee> byDepartment(@PathVariable String dept){
		return repository.findByDepartment(dept);
	}
	
	@GetMapping("/salary/{amount}")
	public List <Employee> salary(@PathVariable double amount){
	 return repository.findSalaryGreater(amount);

}
	@GetMapping("/search/{name}")
	 public List<Employee> search(@PathVariable String name){
		 return repository.searchByName(name);
	 }
}