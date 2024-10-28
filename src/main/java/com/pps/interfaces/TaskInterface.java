package com.pps.interfaces;

import com.pps.entities.Statuses;
import com.pps.entities.Task;

public interface TaskInterface {
    Task addTask(String description);
    void viewTask(Statuses status);
    void updateTask(int id, String description);
    void deleteTask(int id);
    void saveTask();
}
