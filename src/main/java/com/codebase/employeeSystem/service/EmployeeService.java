package com.codebase.employeeSystem.service;

import com.codebase.employeeSystem.constants.AppConstants;
import com.codebase.employeeSystem.dto.EmployeeDto;
import com.codebase.employeeSystem.exception.ResourceNotFoundException;
import com.codebase.employeeSystem.model.Employee;
import com.codebase.employeeSystem.repository.EmployeeRepository;
import com.codebase.employeeSystem.util.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee addEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(employeeDto);
        logger.info("Adding employee"+employeeDto);
        return employeeRepository.save(employee);
    }
    
    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Employee does not exist with id "+id));
        EmployeeDto employeeDto = new EmployeeDto(employee);
        logger.info("Fetched employee "+employeeDto);
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
            logger.info("Updating employee "+employeeDto);
            employeeRepository.save(employee);
            updatedEmployeeDto = new EmployeeDto(employee);
        } catch (Exception e){
            logger.error("Exception occurred in updateEmployeeById", e);
        }

        return updatedEmployeeDto;
    }

    public String deleteEmployeeById(Long empId){
        Employee employee = employeeRepository.findById(empId).orElseThrow(()
                -> new ResourceNotFoundException("Employee does not exist with id "+empId));
        String message = AppConstants.SOME_ERROR_OCCURRED;
        try{
            logger.info("Deleting employee "+employee);
            //employeeRepository.delete(employee);
            message = AppUtils.getAppUtils().getLogString(
                    "Deleted employee ",
                    employee.getFirstName(),
                    " ",
                    employee.getLastName());
        } catch (Exception e){
            logger.error("Exception occurred in updateEmployeeById", e);
        }
        return message;
    }
}
