package test;

import com.pps.entities.TaskStatus;
import com.pps.repositories.TaskRepository;

public class TaskRepositoryTest {
    private static final TaskRepository taskRepository = new TaskRepository();
    public static void main(String[] args) {

//        Testing getTask()
//        testGetTask();

//        Testing updateTask()
//        testUpdateTask();

//        Testing createTask()
//        testCreateTask();

//        Testing deleteTask();
//        testDeleteTask();

//        Testing updateTaskStatus();
        updateTaskStatus();
    }

    public static void testCreateTask() {
        taskRepository.createTask("Second Task");
        taskRepository.createTask("Third Task");
    }

    public static void testGetTask() {
        System.out.println(taskRepository.getTask(TaskStatus.NO_STATUS));
    }

    public static void testUpdateTask() {
        taskRepository.updateTaskDescription(1, "Update First Task");
    }

    public static void testDeleteTask() {
        taskRepository.deleteTask(3);
    }

    public static void updateTaskStatus() {
        taskRepository.updateTaskStatus(2, TaskStatus.DONE);
    }
}
