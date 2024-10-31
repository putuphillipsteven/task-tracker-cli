package com.pps.view;

import com.pps.controllers.TaskController;
import com.pps.entities.Statuses;
import com.pps.interactors.TaskInteractor;
import com.pps.repositories.TaskRepository;
import com.pps.util.InputUtil;

public class TaskManager {



    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();
        TaskInteractor taskInteractor = new TaskInteractor(taskRepository);
        TaskController taskController = new TaskController(taskInteractor);
        while(true) {
            System.out.println("1. View Task");
            System.out.println("2. Create Task");
            System.out.println("3. Update Task Status");
            System.out.println("4. Update Task Description");
            System.out.println("5. Delete Task");
            System.out.println("0. Exit");

            String userChoice = InputUtil.input("Enter your choice");

            switch (userChoice) {
                case "1":
                    System.out.println("1. To-do");
                    System.out.println("2. In Progress");
                    System.out.println("3. Done");
                    String statusFilterUserChoice = InputUtil.input("Enter your status task: ");
                    switch (statusFilterUserChoice) {
                        case "1":
                            taskController.viewTask(Statuses.TO_DO);
                            break;
                        case "2":
                            taskController.viewTask(Statuses.IN_PROGRESS);
                            break;
                        case "3":
                            taskController.viewTask(Statuses.DONE);
                            break;
                        default:
                            System.out.println("Unknown choice");
                            break;
                    }
                    break;
                case "2":
                    String newTaskDescription = InputUtil.input("Enter your task description");
                    taskController.addTask(newTaskDescription);
                    break;
                case "3":
                    taskController.showAllTask();
                    String taskIdWantToUpdated = InputUtil.input("Enter the id that you want to update");

                    System.out.println("1. To-Do");
                    System.out.println("2. In Progress");
                    System.out.println("3. Done");

                    int numTaskId = Integer.parseInt(taskIdWantToUpdated);
                    String statusWantToUpdated = InputUtil.input("Enter the status that you want to assign: ");
                    switch (statusWantToUpdated) {
                        case "1":
                            taskController.markToDo(numTaskId);
                            break;
                        case "2":
                            taskController.markInProgress(numTaskId);
                            break;
                        case "3" :
                            taskController.markDone(numTaskId);
                            break;
                        default:
                            System.out.println("Unknown choices");
                    }
                    break;
                case "4":
                    taskController.showAllTask();
                    String taskIdWantToBeUpdated = InputUtil.input("Enter the id that you want to update the description");
                    String newDescription = InputUtil.input("Enter your new description");
                    taskController.updateTask(Integer.parseInt(taskIdWantToBeUpdated), newDescription);
                    break;
                case "5":
                    taskController.showAllTask();
                    String taskIdWantToDeleted = InputUtil.input("Enter the id that you want to be deleted");
                    taskController.deleteTask(Integer.parseInt(taskIdWantToDeleted));
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Unknown choices");
                    break;
            }
        }
    }


}


