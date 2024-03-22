package com.project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PharmacyExceptionHandler {

    @ExceptionHandler(value = {PharmacyNotFoundException.class})
    public ResponseEntity<Object> handlePharmacyNotFoundException
            (PharmacyNotFoundException pharmacyNotFoundException)
    {
        PharmacyException pharmacyException = new PharmacyException(
                pharmacyNotFoundException.getMessage(),
                pharmacyNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(pharmacyException, HttpStatus.NOT_FOUND);
    }
}