package com.pps.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int lastId = 0;
    private int id;
    private String description;
    private Statuses status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Statuses.TO_DO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static Task fromJson(String json) {
        json = json.replace("{", "").replace("}", "").replace("\"", "");
        String[] json1 = json.split(",");

        String id = json1[0].split(":")[1].strip();
        String description = json1[1].split(":")[1].strip();
        String statusString = json1[2].split(":")[1].strip();
        String createdAtStr = json1[3].split("[a-z]:")[1].strip();
        String updatedAtStr = json1[4].split("[a-z]:")[1].strip();


        Task task = new Task(description);
        task.id = Integer.parseInt(id);
        task.status = Statuses.TO_DO;
        task.createdAt = LocalDateTime.parse(createdAtStr, formatter);
        task.updatedAt = LocalDateTime.parse(updatedAtStr, formatter);

        if (Integer.parseInt(id) > lastId) {
            lastId = Integer.parseInt(id);
        }

        return task;
    }

    public String toJson() {
        return "{\"id\":\"" + id + "\", \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() +
                "\", \"createdAt\":\"" + createdAt.format(formatter) + "\", \"updatedAt\":\"" + updatedAt.format(formatter) + "\"}";
    }

    @Override
    public String toString() {
        return "id: " + id + ", description: " + description.strip() + ", status: " + status.toString() +
                ", createdAt: " + createdAt.format(formatter) + ", updatedAt: " + updatedAt.format(formatter);
    }
}
