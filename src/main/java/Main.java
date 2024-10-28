import com.pps.controllers.TaskController;
import com.pps.entities.Statuses;
import com.pps.interactors.TaskInteractor;
import com.pps.repositories.TaskRepository;

public class Main {
    private static TaskRepository taskRepository = new TaskRepository();

    private static TaskInteractor taskInteractor = new TaskInteractor(taskRepository);

    private static TaskController taskController = new TaskController(taskInteractor);

    public static void main(String[] args) {
        taskController.viewTask(Statuses.TO_DO);
        taskController.addTask("Testing Third Tasks");
    }
}
