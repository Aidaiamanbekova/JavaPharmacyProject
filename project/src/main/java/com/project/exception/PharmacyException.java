package com.project.exception;

import org.springframework.http.HttpStatus;

public class PharmacyException extends RuntimeException {

    private final HttpStatus httpStatus;

    public PharmacyException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}