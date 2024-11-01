import com.pps.controllers.TaskController;
import com.pps.interactors.TaskInteractor;
import com.pps.repositories.TaskRepository;

public class Main {
    static TaskRepository taskRepository = new TaskRepository();
    static TaskInteractor taskInteractor = new TaskInteractor(taskRepository);
    static TaskController taskController = new TaskController(taskInteractor);
    public static void main(String[] args) {

        if(args.length > 0) {
            System.out.println("The command line arguments are: ");
            String mainCommand = "";
            String taskDescription = "";
            String newTaskDescription;
            int taskId;

            for (var command: args) {
                if(command.equals("add")) {
                    mainCommand = args[0];
                    taskDescription = args[1];
                }
            }
            switch (mainCommand) {
                case "add":
                    taskController.addTask(taskDescription);
                    break;
            }
        } else {
            System.out.println("No command line arguments found");
        }
    }
}
