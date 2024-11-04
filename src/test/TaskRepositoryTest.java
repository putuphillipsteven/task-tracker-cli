package test;

import com.pps.entities.TaskStatus;
import com.pps.repositories.TaskRepository;

public class TaskRepositoryTest {
    private static final TaskRepository taskRepository = new TaskRepository();
    public static void main(String[] args) {

//        Testing getTask()
//        testGetTask();

//        Testing updateTask()
            testUpdateTask();

    }

    public static void testGetTask() {
        System.out.println(taskRepository.getTask(TaskStatus.NO_STATUS));
    }

    public static void testUpdateTask() {
        taskRepository.updateTaskDescription(1, "Update First Task");
    }
}
