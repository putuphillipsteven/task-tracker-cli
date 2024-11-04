package com.pps;

import com.pps.entities.TaskStatus;
import com.pps.repositories.TaskRepository;

public class TaskCLI {
    public static void main(String[] args) {
        var taskRepository = new TaskRepository();
        System.out.println(taskRepository.getTask(TaskStatus.NO_STATUS));

    }
}
