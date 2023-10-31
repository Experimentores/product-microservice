package com.experimentores.productsmicroservice.products.exception;

public class InvalidCreateResourceException extends RuntimeException {
    public InvalidCreateResourceException() {

    }
    public InvalidCreateResourceException(String message) {
        super(message);
    }
}
