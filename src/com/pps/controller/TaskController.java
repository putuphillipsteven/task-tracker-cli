package com.pps.controller;

import com.pps.entities.Task;
import com.pps.entities.TaskStatus;
import com.pps.interactor.TaskInteractor;
import com.pps.interfaces.TaskInterface;

import java.util.List;
import java.util.Optional;

public class TaskController implements TaskInterface {
    private final TaskInteractor taskInteractor;

    public TaskController(TaskInteractor taskInteractor) {
        this.taskInteractor = taskInteractor;
    }

    @Override
    public Task createTask(String description) {
        return this.taskInteractor.createTask(description);
    }

    @Override
    public List<Task> getTask(TaskStatus status) {
        return this.taskInteractor.getTask(status);
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return this.taskInteractor.getTaskById(id);
    }

    @Override
    public Task updateTaskDescription(int id, String description) {
        return this.taskInteractor.updateTaskDescription(id, description);
    }

    @Override
    public Task updateTaskStatus(int id, TaskStatus status) {
        return this.taskInteractor.updateTaskStatus(id, status);
    }

    @Override
    public void deleteTask(int id) {
        this.taskInteractor.deleteTask(id);
    }
}
