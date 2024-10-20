package com.codebase.employeeSystem.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = EmployeeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmloyee {

    String message() default "Invalid attribute";
    Class<?>[] groups() default {}; // Used for grouping constraints
    Class<? extends Payload>[] payload() default {}; // Used for providing additional information

}
