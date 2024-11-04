package com.pps.exception;

public class InvalidTaskStatusException extends Exception{
    public InvalidTaskStatusException() {
        super();
    }

    public  InvalidTaskStatusException(String message) {
        super(message);

    }
}
