package com.pps.repositories;

import com.pps.entities.Statuses;
import com.pps.entities.Task;
import com.pps.interfaces.TaskInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Task addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task add successfully :");
        System.out.println(newTask);
        this.saveTask();
        return newTask;
    }

    @Override
    public void viewTask(Statuses status) {
        System.out.println("Task List: ");
        System.out.println(tasks);
    }

    @Override
    public void updateTask(int id, String description) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));

        task.updateTask(description);

        System.out.println("Task with ID: " + id + " updated succesfully");

        saveTask();
    }

    @Override
    public void deleteTask(int id) {
        Task task = findTask(id).orElseThrow(()->new IllegalArgumentException("Task with ID " + id + " not found!"));

        tasks.remove(task);

        System.out.println("Task with ID " + id + " deleted successfully");

        saveTask();
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

    @Override
    public void markToDo(int id) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));

        task.markToDo();

        saveTask();

        Task updatedTask = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));

        System.out.println("Task with ID: " + id + " updated succesfully");

        System.out.println(updatedTask);
    }

    @Override
    public void markInProgress(int id) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));

        task.markInProgress();

        saveTask();

        Task updatedTask = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));

        System.out.println("Task with ID: " + id + " updated succesfully");

        System.out.println(updatedTask);
    }

    @Override
    public void markDone(int id) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));

        task.markDone();

        saveTask();

        Task updatedTask = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));

        System.out.println("Task with ID: " + id + " updated succesfully");

        System.out.println(updatedTask);
    }

    public Optional<Task> findTask(int id) {
        return tasks.stream().filter((task -> task.getId() == id)).findFirst();
    }
}
