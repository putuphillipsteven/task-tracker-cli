package com.pps.entities;

public enum TaskStatus {
    TO_DO("To-do"),
    IN_PROGRESS("In Progress"),
    DONE("Done"),
    NO_STATUS("No Status");

    private final String value;

    TaskStatus(String value) {
        this.value = value;
    }

    public static TaskStatus convertStatusToString(String stringStatus) {
        switch (stringStatus) {
            case "To-do":
                return TaskStatus.TO_DO;
            case "In Progress":
                return TaskStatus.IN_PROGRESS;
            case "Done":
                return TaskStatus.DONE;
            case "No Status":
                return TaskStatus.NO_STATUS;
            default:
                System.out.println("Unknown Statuses");
        }
        return TaskStatus.TO_DO;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
