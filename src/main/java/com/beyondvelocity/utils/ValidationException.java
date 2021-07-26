package com.beyondvelocity.utils;

/*
 * Encapsulates validation errors.
 */
public class ValidationException extends RuntimeException {
    /*
     * Initializes a new validation exception with the specified error.
     */
    public ValidationException(String error) {
        super(error);
    }
}

