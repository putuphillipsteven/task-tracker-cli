package com.pps.exception;

public class TaskNotFoundException extends IllegalArgumentException{
    public  TaskNotFoundException() {
        super();
    }

    public  TaskNotFoundException(String message) {
        super(message);
    }
}
