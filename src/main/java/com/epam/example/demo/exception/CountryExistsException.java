package com.epam.example.demo.exception;


public class CountryExistsException extends RuntimeException {
    public CountryExistsException(String message) {
        super(message);
        System.out.println("--- test");
    }
}
