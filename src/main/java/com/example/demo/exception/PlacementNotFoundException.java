package com.example.demo.exception;

public class PlacementNotFoundException extends RuntimeException {

    public PlacementNotFoundException(String message) {
        super(message);
    }
}