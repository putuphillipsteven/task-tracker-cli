package com.pps.test;

import com.pps.controllers.TaskController;
import com.pps.entities.Statuses;
import com.pps.interactors.TaskInteractor;
import com.pps.repositories.TaskRepository;

public class TestTaskRepository {
    private static TaskRepository taskRepository = new TaskRepository();
    private static TaskInteractor taskInteractor = new TaskInteractor(taskRepository);
    private static TaskController taskController = new TaskController(taskInteractor);

    public static void main(String[] args) {
        testViewTask();
        testMarkToDo();
        testViewTask();
    }

    public static void testViewTask() {
        taskController.viewTask(Statuses.TO_DO);
    }

    public static void testAddTask() {
        taskController.addTask("Third Not Default Task");
        taskController.addTask("Fourth Not Default Task");
        taskController.addTask("Fifth Not Default Task");
    }

    public static void testRemoveTask() {
        taskController.deleteTask(3);
        taskController.deleteTask(4);
        taskController.deleteTask(5);
    }

    public static void testUpdateTask() {
        taskController.updateTask(3, "New Third Description");
        taskController.updateTask(4, "New Fourth Description");
        taskController.updateTask(5, "New Fifth Description");
    }

    public static void testMarkInProgress() {
        taskController.markInProgress(1);
        taskController.markInProgress(2);
        taskController.markInProgress(3);
        taskController.markInProgress(4);
        taskController.markInProgress(5);
    }

    public static void testMarkDone() {
        taskController.markDone(1);
        taskController.markDone(2);
        taskController.markDone(3);
        taskController.markDone(4);
        taskController.markDone(5);
    }

    public static void testMarkToDo() {
        taskController.markToDo(1);
        taskController.markToDo(2);
        taskController.markToDo(3);
        taskController.markToDo(4);
        taskController.markToDo(5);
    }

}
