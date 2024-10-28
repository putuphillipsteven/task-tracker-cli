package com.pps.controllers;

import com.pps.entities.Statuses;
import com.pps.entities.Task;
import com.pps.interactors.TaskInteractor;
import com.pps.interfaces.TaskInterface;

public class TaskController implements TaskInterface {
    private TaskInteractor taskInteractor;

    public TaskController(TaskInteractor taskInteractor) {
        this.taskInteractor = taskInteractor;
    }

    @Override
    public Task addTask(String description) {
        Task newTask = this.taskInteractor.addTask(description);
        return newTask;
    }

    @Override
    public void viewTask(Statuses status) {
        this.taskInteractor.viewTask(status);
    }

    @Override
    public void updateTask(int id, String description) {
        this.taskInteractor.updateTask(id, description);
    }

    @Override
    public void deleteTask(int id) {
        this.taskInteractor.deleteTask(id);
    }

    @Override
    public void saveTask() {
        this.taskInteractor.saveTask();
    }
}
