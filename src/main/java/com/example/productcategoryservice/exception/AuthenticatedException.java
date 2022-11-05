package com.example.productcategoryservice.exception;

public class AuthenticatedException extends RuntimeException {
    public AuthenticatedException(String message) {
        super(message);
    }
}
