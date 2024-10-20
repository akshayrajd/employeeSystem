package com.codebase.employeeSystem.dto;

import com.codebase.employeeSystem.model.Employee;
import com.codebase.employeeSystem.validation.EmployeeValidator;
import com.codebase.employeeSystem.validation.ValidEmloyee;

public class EmployeeDto {

    private long empId;

    @ValidEmloyee(message = "First name should have atleast 1 character")
    private String firstName;
    private String lastName;
    private String emailId;

    public EmployeeDto() {
        super();
    }

    public EmployeeDto(Employee employee){
        this.empId = employee.getEmpId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.emailId = employee.getEmailId();
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
