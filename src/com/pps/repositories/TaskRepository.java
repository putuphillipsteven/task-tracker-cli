package com.pps.repositories;

import com.pps.entities.Task;
import com.pps.entities.TaskStatus;
import com.pps.exception.InvalidTaskStatusException;
import com.pps.exception.SameStatusException;
import com.pps.exception.TaskNotFoundException;
import com.pps.interfaces.TaskInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TaskRepository implements TaskInterface {
    private final Path FILE_PATH = Path.of("tasks.json");
    private List<Task> tasks;

    public TaskRepository() {
            this.tasks = readTaskFromJSON();
    }

    private List<Task> readTaskFromJSON(){
        List<Task> taskFromJSON = new ArrayList<>();

        if(!Files.exists(FILE_PATH)) {
            /*
            * Those code means if nothing file found it will make a new file
            * How the file created? with a createTask() function.
            * */
            System.out.println("File not found, system will make a new files for you.");

            this.tasks = new ArrayList<>();

            this.createTask("First default Task");

        }


        try {
            String jsonContent = Files.readString(FILE_PATH);

            if(jsonContent.length() <= 10) {
                System.out.println("File is empty, system will make a new tasks for you.");

                this.tasks = new ArrayList<>();

                this.createTask("First default Task");

                this.getTask(TaskStatus.NO_STATUS);
            }

            if(jsonContent.length() > 10) {
                String[] taskLists = jsonContent.replace("[", "").replace("]", "").split("},");
                for(var taskJson: taskLists) {
                    if(!taskJson.endsWith("}")) {
                        taskJson = taskJson + "}";
                        taskFromJSON.add(Task.fromJson(taskJson));
                    } else {
                        taskFromJSON.add(Task.fromJson(taskJson));
                    }
                    return taskFromJSON;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.getTask(TaskStatus.NO_STATUS);
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
    public Optional<Task> getTaskById(int id) {
        return tasks.stream().filter((task -> task.getId() == id)).findFirst();
    }

    @Override
    public Task updateTaskDescription(int id, String description) {
        var taskWantToUpdate = getTaskById(id).orElseThrow(() -> new TaskNotFoundException("Task not found!"));

        taskWantToUpdate.updateTaskDescription(id, description);

        System.out.println("Task updated succesfully (ID: " + id + ")");

        saveJsonFile();

        return getTaskById(id).orElseThrow(() -> new TaskNotFoundException("Task not found!"));
    }

    @Override
    public Task updateTaskStatus(int id, TaskStatus status){
        var taskWantToUpdate = getTaskById(id).orElseThrow(() -> new TaskNotFoundException("Task not found!"));

        var taskStatusBefore = taskWantToUpdate.getStatus();

        if(status.equals(taskStatusBefore)) {
            throw new SameStatusException("Cant update if the status same like before");
        }

        try {
        switch (status) {
            case TaskStatus.NO_STATUS :
                taskWantToUpdate.updateTaskStatus(TaskStatus.NO_STATUS);
                break;
            case TaskStatus.TO_DO:
                taskWantToUpdate.updateTaskStatus(TaskStatus.TO_DO);
                break;
            case TaskStatus.IN_PROGRESS:
                taskWantToUpdate.updateTaskStatus(TaskStatus.IN_PROGRESS);
                break;
            case TaskStatus.DONE:
                taskWantToUpdate.updateTaskStatus(TaskStatus.DONE);
                break;
            default:
                System.out.println("Invalid Task Status");
                break;
            }
        } catch (TaskNotFoundException | InvalidTaskStatusException e) {
            e.printStackTrace();
        }

        System.out.println("Task updated succesfully (ID: " + id + ")");

        saveJsonFile();
        return getTaskById(id).orElseThrow(() -> new TaskNotFoundException("Task not found!"));
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
        var taskWantToDeleted = getTaskById(id).orElseThrow(() -> new TaskNotFoundException("Task Not Found"));

        tasks.remove(taskWantToDeleted);

        System.out.println("Task with (ID: " + id + ") deleted successfully");

        saveJsonFile();
    }
}
