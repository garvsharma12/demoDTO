package com.javaDTO.demoDTO.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaDTO.demoDTO.Entity.Employee;
import com.javaDTO.demoDTO.Repository.EmployeeRepository;

@Service 
public class EmployeeService {

    EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<String> createEmployee(Employee emp) {
        employeeRepository.save(emp);
        return ResponseEntity.ok("Employee created successfully");
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public ResponseEntity<String> deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
    
}
