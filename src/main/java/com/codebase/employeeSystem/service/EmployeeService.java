package com.codebase.employeeSystem.service;

import com.codebase.employeeSystem.controller.EmployeeController;
import com.codebase.employeeSystem.dto.EmployeeDto;
import com.codebase.employeeSystem.exception.ResourceNotFoundException;
import com.codebase.employeeSystem.model.Employee;
import com.codebase.employeeSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EmployeeService {

    private Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee addEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(employeeDto);
        return employeeRepository.save(employee);
    }
    
    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Employee does not exist with id "+id));
        EmployeeDto employeeDto = new EmployeeDto(employee);
        return employeeDto;
    }

    public EmployeeDto updateEmployeeById(EmployeeDto employeeDto){
        Employee employee = employeeRepository.findById(employeeDto.getEmpId()).orElseThrow(()
                -> new ResourceNotFoundException("Employee does not exist with id "+employeeDto.getEmpId()));
        EmployeeDto updatedEmployeeDto = null;
        try{
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmailId(employeeDto.getEmailId());
            employeeRepository.save(employee);
            return new EmployeeDto(employee);
        } catch (Exception e){
           e.printStackTrace();
        }

        return updatedEmployeeDto;
    }
}
