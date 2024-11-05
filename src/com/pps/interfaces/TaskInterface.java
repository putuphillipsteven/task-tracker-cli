package com.pps.interfaces;

import com.pps.entities.TaskStatus;
import com.pps.entities.Task;
import com.pps.exception.TaskNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TaskInterface {
    Task createTask(String description);
    List<Task> getTask(TaskStatus status);
    Optional<Task> getTaskById(int id);
    Task updateTaskDescription(int id, String description);
    Task updateTaskStatus(int id, TaskStatus status);
    void saveJsonFile();
    void deleteTask(int id);
}
