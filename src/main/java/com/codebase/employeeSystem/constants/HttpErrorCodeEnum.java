package com.codebase.employeeSystem.constants;

import org.springframework.http.HttpStatus;

public enum HttpErrorCodeEnum {

    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "Uh oh! Bad request", HttpStatus.BAD_REQUEST),
    NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Oops! The requested resource is not found", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ah snap! Internal server error occurred",
            HttpStatus.INTERNAL_SERVER_ERROR);
    
    private int errorCode;
    private String errorMessage;
    private HttpStatus status;

    HttpErrorCodeEnum(int errorCode, String errorMessage, HttpStatus status) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
