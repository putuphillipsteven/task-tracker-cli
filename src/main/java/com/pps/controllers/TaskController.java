package com.pps.controllers;

import com.pps.entities.Statuses;
import com.pps.interactors.TaskInteractor;
import com.pps.interfaces.TaskInterface;

public class TaskController implements TaskInterface {
    private TaskInteractor taskInteractor;

    public TaskController(TaskInteractor taskInteractor) {
        this.taskInteractor = taskInteractor;
    }

    @Override
    public void addTask(String description) {
        this.taskInteractor.addTask(description);
        this.taskInteractor.saveTask();
    }

    @Override
    public void viewTask(Statuses status) {
        this.taskInteractor.viewTask(status);
    }

    @Override
    public void updateTask(int id, String description) {

    }

    @Override
    public void deleteTask(int id) {

    }

    @Override
    public void saveTask() {
        this.taskInteractor.saveTask();
    }
}
