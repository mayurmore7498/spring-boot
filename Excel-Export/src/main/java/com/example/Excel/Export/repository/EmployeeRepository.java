package com.example.Excel.Export.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Excel.Export.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee ,Long>{

}
