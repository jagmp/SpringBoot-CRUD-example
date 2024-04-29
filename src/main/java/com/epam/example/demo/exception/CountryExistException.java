package com.epam.example.demo.exception;
public class CountryExistException extends RuntimeException{
    public CountryExistException(String message) {
        super(message);
    }
}
