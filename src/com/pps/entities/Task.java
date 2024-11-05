package com.pps.entities;

import com.pps.exception.InvalidTaskStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Task {
    private static int lastId = 0;
    private int id;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = TaskStatus.TO_DO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateTaskDescription(int id, String newDescription) {
        this.description = newDescription;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateTaskStatus(TaskStatus status) throws InvalidTaskStatusException{
        switch (status) {
            case TO_DO:
                this.status = TaskStatus.TO_DO;
                break;
            case IN_PROGRESS:
                this.status = TaskStatus.IN_PROGRESS;
                break;
            case DONE:
                this.status = TaskStatus.DONE;
                break;
            default:
                throw new InvalidTaskStatusException("Invalid Task Status");
        }
    }



    public static Task fromJson(String json) {
        json = json.replace("{", "").replace("}", "").replace("\"", "");

        String[] newJson = json.split(",");


        String id = newJson[0].split(":")[1].strip();
        String description = newJson[1].split(":")[1].strip();
        String statusString = newJson[2].split(":")[1].strip();
        String createdAtStr = newJson[3].split("[a-z]:")[1].strip();
        String updatedAtStr = newJson[4].split("[a-z]:")[1].strip();

        Task task = new Task(description);

        task.id = Integer.parseInt(id);
        task.status = TaskStatus.convertStatusToString(statusString);
        task.createdAt = LocalDateTime.parse(createdAtStr, formatter);
        task.updatedAt = LocalDateTime.parse(updatedAtStr, formatter);

        if (Integer.parseInt(id) > lastId) {
            lastId = Integer.parseInt(id);
        }

        return task;
    }

    public String toJson() {
        return "{\"id\":\"" + this.id + "\", \"description\":\"" + this.description.strip() + "\", \"status\":\"" + this.status.toString() +
                "\", \"createdAt\":\"" + this.createdAt.format(formatter) + "\", \"updatedAt\":\"" + this.updatedAt.format(formatter) + "\"}";
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", description: " + this.description.strip() + ", status: " + this.status.toString() +
                ", createdAt: " + this.createdAt.format(formatter) + ", updatedAt: " + this.updatedAt.format(formatter);
    }

    public int getId() {
        return this.id;
    }

    public TaskStatus getStatus() {
        return this.status;
    }
}
