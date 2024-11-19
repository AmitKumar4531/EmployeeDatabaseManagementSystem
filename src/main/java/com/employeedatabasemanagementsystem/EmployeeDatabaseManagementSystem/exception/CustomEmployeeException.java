package com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class CustomEmployeeException extends  RuntimeException {
    private static final long serialVersionUID = 1L;

    HttpStatus status;
    String message;



    public CustomEmployeeException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }



}
