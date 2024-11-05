package com.pps.interactor;

import com.pps.entities.Task;
import com.pps.entities.TaskStatus;
import com.pps.interfaces.TaskInterface;
import com.pps.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskInteractor implements TaskInterface {
    private final TaskRepository taskRepository;

    public TaskInteractor(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String description) {
        return this.taskRepository.createTask(description);
    }

    @Override
    public List<Task> getTask(TaskStatus status) {
        return this.taskRepository.getTask(status);
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return this.taskRepository.getTaskById(id);
    }

    @Override
    public Task updateTaskDescription(int id, String description) {
        return this.taskRepository.updateTaskDescription(id, description);
    }

    @Override
    public Task updateTaskStatus(int id, TaskStatus status) {
        return this.taskRepository.updateTaskStatus(id, status);
    }

    @Override
    public void deleteTask(int id) {
        this.taskRepository.deleteTask(id);
    }
}
