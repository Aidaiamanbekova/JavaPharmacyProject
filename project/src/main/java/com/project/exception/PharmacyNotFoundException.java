package com.project.exception;

public class PharmacyNotFoundException extends RuntimeException {

    public PharmacyNotFoundException(String message) {
        super(message);
    }

    public PharmacyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}