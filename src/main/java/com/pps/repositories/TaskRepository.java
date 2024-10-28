package com.pps.repositories;

import com.pps.entities.Statuses;
import com.pps.entities.Task;
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
        this.tasks = loadTask();
    }

    private List<Task> loadTask(){
        List<Task> storedTasks = new ArrayList<>();

        if(!Files.exists(FILE_PATH)) {
            return new ArrayList<>();
        }

        try {
            String jsonContent = Files.readString(FILE_PATH);
            String[] taskLists = jsonContent.replace("[", "").replace("]", "").split("},");

            for (String taskJson: taskLists) {
                if(!taskJson.endsWith("}")) {
                    taskJson = taskJson + "}";
                    storedTasks.add(Task.fromJson(taskJson));
                } else {
                    storedTasks.add(Task.fromJson(taskJson));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return storedTasks;
    }

    @Override
    public void addTask(String description) {
        Task newTask = new Task(description);
        System.out.println("NEW TASK: " + newTask);
        tasks.add(newTask);
        System.out.println("Task add successfully");
        this.saveTask();
    }

    @Override
    public void viewTask(Statuses status) {
        System.out.println("Task List: ");
        System.out.println(tasks);
    }

    @Override
    public void updateTask(int id, String description) {

    }

    @Override
    public void deleteTask(int id) {

    }

    @Override
    public void saveTask() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(tasks.get(i).toJson());
            if(i < tasks.size() - 1) {
                sb.append(", \n");
            }
        }
        sb.append("\n]");

        String jsonContent = sb.toString();
        try {
            Files.writeString(FILE_PATH, jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
