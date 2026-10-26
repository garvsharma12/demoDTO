package com.javaDTO.demoDTO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaDTO.demoDTO.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
