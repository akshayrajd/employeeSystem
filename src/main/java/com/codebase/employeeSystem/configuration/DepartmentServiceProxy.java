package com.codebase.employeeSystem.configuration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codebase.employeeSystem.dto.DepartmentDto;

@FeignClient(name = "department-service")
public interface DepartmentServiceProxy {

	@PostMapping("/departments")
	ResponseEntity<DepartmentDto> addDepartment(@RequestBody(required = false) @Validated DepartmentDto departmentDto);
	
	@GetMapping("/departments")
	ResponseEntity<List<DepartmentDto>> getDepartments();
}
