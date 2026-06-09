package com.blaze.backend.restaurant.exception;

public class EmployeeNotFoundException extends RuntimeException 
{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}