package com.codebase.employeeSystem.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeValidator implements ConstraintValidator<ValidEmloyee, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.trim().isEmpty();
    }
}
