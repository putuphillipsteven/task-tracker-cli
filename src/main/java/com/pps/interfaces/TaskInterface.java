package com.pps.interfaces;

import com.pps.entities.Statuses;

public interface TaskInterface {
    void addTask(String description);
    void viewTask(Statuses status);
    void updateTask(int id, String description);
    void deleteTask(int id);
    void saveTask();
}
