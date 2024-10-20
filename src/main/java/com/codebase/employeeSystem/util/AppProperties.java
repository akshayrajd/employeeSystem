package com.codebase.employeeSystem.util;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/*
 @Configuration to annotate class as configuration class
 @ConfigurationProperties(prefix = "employee") to get property with a prefix
@Validated to ensure validations on the property
*/

@Configuration
@ConfigurationProperties(prefix = "employee")
@Validated
public class AppProperties {

    @NotNull
    @NotEmpty
    private String departments;


    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }
}
