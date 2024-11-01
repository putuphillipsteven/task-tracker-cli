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
       taskRepository.saveTask();
    }

    @Override
    public void markToDo(int id) {
        taskRepository.markToDo(id);
    }

    @Override
    public void markInProgress(int id) {
        taskRepository.markInProgress(id);
    }

    @Override
    public void markDone(int id) {
        taskRepository.markDone(id);
    }

    @Override
    public void showAllTask() {
        taskRepository.showAllTask();
    }
}
