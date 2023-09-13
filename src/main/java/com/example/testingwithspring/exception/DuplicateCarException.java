package com.example.testingwithspring.exception;


public class DuplicateCarException extends RuntimeException{
    public DuplicateCarException(String message) {
        super(message);
    }
}
