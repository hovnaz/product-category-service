package com.example.productcategoryservice.exception;

public class UserEmailConflictException extends RuntimeException {
    public UserEmailConflictException(String message){
        super(message);
    }
}
