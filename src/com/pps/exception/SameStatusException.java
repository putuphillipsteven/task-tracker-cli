package com.pps.exception;

public class SameStatusException extends IllegalArgumentException{
    public SameStatusException() {
        super();
    }

    public SameStatusException(String message) {
        super(message);
    }
}
