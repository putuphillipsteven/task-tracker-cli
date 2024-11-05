package com.pps.util;

public class PrintCommandHelper {
    public static void print(){
        System.out.println("Show all task list: ");
        System.out.println("java com/pps/TaskCLI.java list");
        System.out.println("");

        System.out.println("Show to do task list: ");
        System.out.println("java com/pps/TaskCLI.java list todo");
        System.out.println("");

        System.out.println("Show in progress task list: ");
        System.out.println("java com/pps/TaskCLI.java list in-progress");
        System.out.println("");


        System.out.println("Show done task list: ");
        System.out.println("java com/pps/TaskCLI.java list done");
        System.out.println("");

        System.out.println("Add task: ");
        System.out.println("java com/pps/TaskCLI.java add " + "\"Your task description\"" );
        System.out.println("");

        System.out.println("Update task description: ");
        System.out.println("java com/pps/TaskCLI.java update " + "[the id task]" + "\" Your task description\"" );
        System.out.println("");

        System.out.println("Mark task as done");
        System.out.println("java com/pps/TaskCLI.java mark-done " + "[the id task]" );
        System.out.println("");

        System.out.println("Mark task as in-progress");
        System.out.println("java com/pps/TaskCLI.java mark-in-progress" + "[the id task]");
        System.out.println("");

        System.out.println("Mark task as todo");
        System.out.println("java com/pps/TaskCLI.java mark-todo" + "[the id task]");
        System.out.println("");

        System.out.println("Delete task");
        System.out.println("java com/pps/TaskCLI.java delete " + "[the id task]");
        System.out.println("");


    }
}
