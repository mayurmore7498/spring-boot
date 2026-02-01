package com.example.custom_query.repository;

import com.example.custom_query.model.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL
    @Query("SELECT e FROM Employee e WHERE e.department = ?1")
    List<Employee> findByDepartment(String department);

    // JPQL named parameter
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findSalaryGreater(@Param("salary") Double salary);

    // Native Query
    @Query(value = "SELECT * FROM employee WHERE salary >= ?1", nativeQuery = true)
    List<Employee> findSalaryNative(Double salary);

    // LIKE query
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> searchByName(@Param("name") String name);
}
