package com.codebase.employeeSystem.dto;

import jakarta.annotation.Nonnull;

public class DepartmentDto {

    private long deptId;

    @Nonnull
    private String deptName;
    private String envDetails;

    public DepartmentDto() {
        super();
    }

    public DepartmentDto(long deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

	public String getEnvDetails() {
		return envDetails;
	}

	public void setEnvDetails(String envDetails) {
		this.envDetails = envDetails;
	}
    
    
}
