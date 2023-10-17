package com.example.microserviceproducts.exception;

public class ValidationException extends RuntimeException{
    public ValidationException() {

    }
    public ValidationException(String message) {
        super(message);
    }
}
