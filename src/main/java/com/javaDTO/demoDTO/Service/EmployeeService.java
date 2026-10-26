package com.javaDTO.demoDTO.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaDTO.demoDTO.Entity.Employee;
import com.javaDTO.demoDTO.Repository.EmployeeRepository;
import com.javaDTO.demoDTO.dto.RequestDTO;
import com.javaDTO.demoDTO.dto.RespondDTO;

@Service 
public class EmployeeService {

    EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public RespondDTO createEmployee(RequestDTO empDTO) {
        Employee employee = mapToEntity(empDTO);

        employee.setCreatedAt(java.time.LocalDateTime.now());
        employee.setUpdatedAt(java.time.LocalDateTime.now());

        Employee employeeResp = employeeRepository.save(employee);
        return mapToDTO(employeeResp);
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

    public Employee mapToEntity(RequestDTO empDTO) {
        Employee employee = new Employee();
        employee.setName(empDTO.getName());
        employee.setBranch(empDTO.getBranch());
        employee.setEmail(empDTO.getEmail());
        return employee;
    }

    public RespondDTO mapToDTO(Employee employee) {
        RespondDTO empDTO = new RespondDTO();
        empDTO.setId(employee.getId());
        empDTO.setName(employee.getName());
        empDTO.setBranch(employee.getBranch());
        empDTO.setEmail(employee.getEmail());
        empDTO.setMessage("Employee saved successfully");
        empDTO.setCreatedAt(employee.getCreatedAt());
        empDTO.setUpdatedAt(employee.getUpdatedAt());
        return empDTO;
    }

}
