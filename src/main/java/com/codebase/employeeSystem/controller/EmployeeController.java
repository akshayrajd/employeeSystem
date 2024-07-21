package com.codebase.employeeSystem.controller;

import com.codebase.employeeSystem.dto.EmployeeDto;
import com.codebase.employeeSystem.model.Employee;
import com.codebase.employeeSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employeeManagement")
@CrossOrigin
public class EmployeeController {

    private Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        logger.info("fetching employees list");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody (required = false) EmployeeDto employeeDto){
        logger.info("Adding new employee" +employeeDto);
        if(employeeDto != null){
            return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/employees")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody (required = false) EmployeeDto employeeDto){
        EmployeeDto updatedEmployee = employeeService.updateEmployeeById(employeeDto);
        if(updatedEmployee != null){
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

}
