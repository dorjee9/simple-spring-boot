package com.simplecode.demo.exception;

import lombok.Data;

@Data
public class EmployeeNotFoundException extends RuntimeException{
    private String message;
    public EmployeeNotFoundException(String message){
        this.message = message;
    }
}
