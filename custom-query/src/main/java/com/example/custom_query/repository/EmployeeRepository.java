package com.example.custom_query.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.custom_query.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee ,Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.department=?1")
	List<Employee> findByDepartment(String department);
	
	@Query("SELECT e FROM Employee e WHERE e.salary >:salary")
	List<Employee>findSalaryGreater(@Param("salary")Double salary);
	
	@Query(value ="SELECT * FROM employee WHERE salary >=?1",nativeQuery=true)
	List<Employee>findSalaryNative(Double salary);
	
	@Query("SELECT e FORM Employee e WHERE e.name LIKE %:name%")
	List<Employee>searchByName(@Param("name") String name);

}
