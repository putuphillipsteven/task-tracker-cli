package com.pps;

import com.pps.controller.TaskController;
import com.pps.entities.TaskStatus;
import com.pps.interactor.TaskInteractor;
import com.pps.repositories.TaskRepository;
import com.pps.util.PrintCommandHelper;

public class TaskCLI {
    private static final TaskRepository taskRepository = new TaskRepository();
    private static final TaskInteractor taskInteractor = new TaskInteractor(taskRepository);
    private static final TaskController taskController = new TaskController(taskInteractor);


    public static void main(String[] args) {
        if(args.length > 0) {
            String mainCommand = args[0];

            String taskDescription = "";

            String newTaskDescription;

            int taskId;

            switch (mainCommand) {
                case "list":
                    if(args.length == 2){
                        String secondCommand = args[1];
                        switch (secondCommand) {
                            case "done":
                                System.out.println(taskController.getTask(TaskStatus.DONE));
                                break;
                            case "todo":
                                System.out.println(taskController.getTask(TaskStatus.TO_DO));
                                break;
                            case "in-progress":
                                System.out.println(taskController.getTask(TaskStatus.IN_PROGRESS));
                                break;
                        }
                    }   else {
                        System.out.println(taskController.getTask(TaskStatus.NO_STATUS));
                        break;
                    }
                    break;
                case "add":
                    taskDescription = args[1];
                    taskController.createTask(taskDescription);
                    break;
                case "update":
                    taskId = Integer.parseInt(args[1]);
                    newTaskDescription = args[2];
                    taskController.updateTaskDescription(taskId, newTaskDescription);
                    break;
                case "mark-in-progress":
                    taskId = Integer.parseInt(args[1]);
                    taskController.updateTaskStatus(taskId, TaskStatus.IN_PROGRESS);
                    break;
                case "mark-done":
                    taskId = Integer.parseInt(args[1]);
                    taskController.updateTaskStatus(taskId, TaskStatus.DONE);
                    break;
                case "todo":
                    taskId = Integer.parseInt(args[1]);
                    taskController.updateTaskStatus(taskId, TaskStatus.TO_DO);
                    break;
                case "delete":
                    taskId = Integer.parseInt(args[1]);
                    taskController.deleteTask(taskId);
                    break;
                case "help":
                    PrintCommandHelper.print();
                    break;
            }
        } else {
            System.out.println("No command line arguments found");
        }
    }
}
