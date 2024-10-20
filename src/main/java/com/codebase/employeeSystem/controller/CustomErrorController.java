package com.codebase.employeeSystem.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
//public class CustomErrorController implements ErrorController {
public class CustomErrorController {
    //2nd approach to handle exceptions.
   /* @RequestMapping("/error")
    public ResponseEntity<String> handleError(WebRequest webRequest) throws Exception {
        ResponseEntity<String> response = null;
        Integer statusCode = (Integer) webRequest.getAttribute("javax.servlet.error.status_code", WebRequest.SCOPE_REQUEST);
        if (statusCode != null) {
            HttpStatus status = HttpStatus.valueOf(statusCode);
            if(status.equals(HttpStatus.BAD_REQUEST)) {
                return ResponseEntity.badRequest().build();
            } else if(status.equals(HttpStatus.NOT_FOUND)) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.internalServerError().build();
            }
        }
        return response;
    }*/
}
