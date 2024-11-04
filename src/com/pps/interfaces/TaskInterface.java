package com.pps.interfaces;

import com.pps.entities.TaskStatus;
import com.pps.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskInterface {
    Task createTask(String description);
    List<Task> getTask(TaskStatus status);
    List<Task> updateTask(int id, String description);
    List<Task> updateTaskStatus(int id);
    void saveJsonFile();
    void deleteTask(int id);
}
