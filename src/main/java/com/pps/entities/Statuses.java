package com.pps.entities;

public enum Statuses {
    TO_DO("To-do"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private final String value;

    Statuses(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
