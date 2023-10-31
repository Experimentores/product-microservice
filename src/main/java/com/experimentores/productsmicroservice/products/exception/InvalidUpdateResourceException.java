package com.experimentores.productsmicroservice.products.exception;

public class InvalidUpdateResourceException extends RuntimeException {
    public InvalidUpdateResourceException() {

    }
    public InvalidUpdateResourceException(String message) {
        super(message);
    }
}
