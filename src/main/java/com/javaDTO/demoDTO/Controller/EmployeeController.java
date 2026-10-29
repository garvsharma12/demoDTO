package com.javaDTO.demoDTO.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaDTO.demoDTO.Entity.Employee;
import com.javaDTO.demoDTO.Service.EmployeeService;
import com.javaDTO.demoDTO.dto.RequestDTO;
import com.javaDTO.demoDTO.dto.RespondDTO;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/employees")
public class EmployeeController {
    
    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //create a new Employee
    @PostMapping("create")
    public ResponseEntity<RespondDTO> createEmployee(@Valid @RequestBody RequestDTO empRequestDTO) {
        RespondDTO employeeResp = employeeService.createEmployee(empRequestDTO);
        return ResponseEntity.ok(employeeResp);
    }

    // get all employees
    @GetMapping("getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // get employee by id
    @GetMapping("getById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // delete employee by id
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
