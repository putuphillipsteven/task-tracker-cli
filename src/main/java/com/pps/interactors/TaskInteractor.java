package com.pps.interactors;

import com.pps.entities.Statuses;
import com.pps.entities.Task;
import com.pps.interfaces.TaskInterface;
import com.pps.repositories.TaskRepository;

public class TaskInteractor implements TaskInterface {
    private TaskRepository taskRepository;

    public TaskInteractor(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTask(String description) {
        Task newTask = taskRepository.addTask(description);
        return  newTask;
    }

    @Override
    public void viewTask(Statuses status) {
        taskRepository.viewTask(status);
    }

    @Override
    public void updateTask(int id, String description) {
        taskRepository.updateTask(id, description);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }

    @Override
    public void saveTask() {
        this.taskRepository.saveTask();
    }
}
