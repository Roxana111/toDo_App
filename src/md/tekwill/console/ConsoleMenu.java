package md.tekwill.console;

import md.tekwill.task.Task;
import md.tekwill.task.TaskManager;

import java.util.Scanner;

public class ConsoleMenu {

    private TaskManager taskManager;
    private Scanner scanner;

    public ConsoleMenu() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exitSelected = false;
        do {
            System.out.println("\tWelcome to TODO List App");
            System.out.println("Available options:");
            System.out.println("[1] View all tasks");
            System.out.println("[2] Add new task");
            System.out.println("[3] Delete a task");
            System.out.println("[4] Update a task");
            System.out.println("[0] Exit");
            System.out.print(">> ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAllTasks();
                    break;
                case 2:
                    addNewTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    updateTask();
                    break;
                case 0:
                    System.out.println(" Thank you for using the app! Have a blissful day! ");
                    exitSelected = true;
                    break;
                default:
                    System.out.println("Wrong option!\nTry again!\nPlease enter \"[1]\",\"[2]\",\"[3]\",\"[4]\" or \"[0]\"");
            }
        } while (!exitSelected);

    }

    private boolean handleUserChoice(int userChoice) {
        return true;
    }

    private void showAllTasks() {
        Task[] tasks = taskManager.getAll();
        System.out.println("All tasks: ");
        if (tasks.length == 0) {
            System.out.println("No tasks yet ! \n");
        } else {
            for (Task task : tasks) {
                System.out.println("\t[" + task.getId() + "]" + task.getTitle());
                System.out.println("\tDescription: " + task.getDescription());
                System.out.println("\tTarget date: " + task.getTargetDate());
                System.out.println("\tDone: " + task.isDone() + " \n");
            }
        }


    }

    private void addNewTask() {
        System.out.println("Input unique ID (integer) for this task: ");
        int newId = scanner.nextInt();
        System.out.println("Insert a title for your task: ");
        scanner.nextLine();
        String newTitle = scanner.nextLine();
        System.out.println("Provide a description of your task: ");
        String newDescription = scanner.nextLine();
        System.out.println("Insert the target date for your task: ");
        String newTargetDate = scanner.nextLine();
        taskManager.add(new Task(newId, newTitle, newDescription, newTargetDate));

    }

    private void deleteTask() {
        showAllTasks();
        System.out.println("Input the ID of task to delete");
        int newId = scanner.nextInt();
        taskManager.delete(newId);
    }

    private void updateTask() {
        showAllTasks();
        System.out.println("Input the ID of task to edit: ");
        int newId = scanner.nextInt();
        System.out.println("Is the task done? (accepted values are: true | false");
        boolean newValue = scanner.nextBoolean();
        taskManager.update(newId, newValue);
    }

}
