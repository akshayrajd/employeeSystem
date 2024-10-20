package com.codebase.employeeSystem.exception;

import com.codebase.employeeSystem.constants.HttpErrorCodeEnum;
import com.codebase.employeeSystem.model.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomError> handle400Exception(BadRequestException exc) {
        CustomError error = new CustomError(HttpErrorCodeEnum.BAD_REQUEST.getErrorCode(),
                HttpErrorCodeEnum.BAD_REQUEST.getErrorMessage());
        return new ResponseEntity<CustomError>(error, HttpErrorCodeEnum.BAD_REQUEST.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CustomError> handle400Exception(MethodArgumentNotValidException exc) {
        CustomError error = new CustomError(HttpErrorCodeEnum.BAD_REQUEST.getErrorCode(),
                HttpErrorCodeEnum.BAD_REQUEST.getErrorMessage());
        return new ResponseEntity<CustomError>(error, HttpErrorCodeEnum.BAD_REQUEST.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CustomError> handle404Exception(ResourceNotFoundException exc) {
        CustomError error = new CustomError(HttpErrorCodeEnum.NOT_FOUND.getErrorCode(),
                HttpErrorCodeEnum.NOT_FOUND.getErrorMessage());
        return new ResponseEntity<CustomError>(error, HttpErrorCodeEnum.NOT_FOUND.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CustomError> handle404Exception(NoResourceFoundException exc) {
        CustomError error = new CustomError(HttpErrorCodeEnum.NOT_FOUND.getErrorCode(),
                HttpErrorCodeEnum.NOT_FOUND.getErrorMessage());
        return new ResponseEntity<CustomError>(error, HttpErrorCodeEnum.NOT_FOUND.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CustomError> handleException(Exception exc) {
        CustomError error = new CustomError(HttpErrorCodeEnum.INTERNAL_SERVER_ERROR.getErrorCode(),
                HttpErrorCodeEnum.INTERNAL_SERVER_ERROR.getErrorMessage());
        return new ResponseEntity<CustomError>(error, HttpErrorCodeEnum.INTERNAL_SERVER_ERROR.getStatus());
    }
}
