package com.pps.repositories;

import com.pps.entities.Task;
import com.pps.entities.TaskStatus;
import com.pps.interfaces.TaskInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class TaskRepository implements TaskInterface {
    private final Path FILE_PATH = Path.of("tasks.json");
    private List<Task> tasks;

    public TaskRepository() {
            this.tasks = readTaskFromJSON();
    }

    private List<Task> readTaskFromJSON(){
        List<Task> taskFromJSON = new ArrayList<>();

        if(!Files.exists(FILE_PATH)) {
            System.out.println("File not found, system will make a new files for you.");

            this.tasks = new ArrayList<>();

            this.createTask("First default Task");

            return new ArrayList<>();
        }


        try {
            String jsonContent = Files.readString(FILE_PATH);
            String[] taskLists = jsonContent.replace("[", "").replace("]", "").split("},");

            for(var taskJson: taskLists) {
                if(!taskJson.endsWith("}")) {
                    taskJson = taskJson + "}";
                    taskFromJSON.add(Task.fromJson(taskJson));
                } else {
                    taskFromJSON.add(Task.fromJson(taskJson));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskFromJSON;
    }

    @Override
    public Task createTask(String description) {
        var newTask = new Task(description);

        tasks.add(newTask);

        System.out.println("Task add successfully (ID: " + newTask.getId() + ")");

        this.saveJsonFile();

        return newTask;
    }

    @Override
    public List<Task> getTask(TaskStatus status) {
        return this.readTaskFromJSON();
    }

    @Override
    public List<Task> updateTask(int id, String description) {
        return List.of();
    }

    @Override
    public List<Task> updateTaskStatus(int id) {
        return List.of();
    }

    @Override
    public void saveJsonFile() {
        var sb = new StringBuilder();

        sb.append("[\n");

        for (var i = 0; i < tasks.size(); i++) {
            sb.append(tasks.get(i).toJson());
            if (i < tasks.size() - 1) {
                sb.append(", \n");
            }
        }

        sb.append("\n]");

        var jsonContent = sb.toString();

        try {
            Files.writeString(FILE_PATH, jsonContent);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(int id) {

    }
}
