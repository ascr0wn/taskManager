package features;

import java.util.*;

import model.Task;

public class UserOperations {
    public static Scanner scan = new Scanner(System.in);

    public static Task addTask() {
        System.out.print("Enter your Task name: ");
        String taskName = scan.nextLine();
        System.out.print("Enter your Task Details: ");
        String taskDetail = scan.nextLine();
        Task t1 = new Task(taskName, taskDetail);
        return t1;

    }

    public static void editTask(ArrayList<Task> list) {
        System.out.println("Printing out your Tasklist: ");
        int i = 0;
        for (Task task : list) {
            System.out.println(i + ": Name - " + task.getTasksName());
            System.out.println(i + ": Detail - " + task.getTaskDetail());
            i++;
        }
        System.out.print("Please select the task that you would like to edit: ");
        int choice = scan.nextInt();
        System.out.print("\nEnter the new Task Name for the Selected Task: ");
        String taskName = scan.next();
        System.out.print("\nEnter new Details for the Selected Task: ");
        String taskDetail = scan.next();
        Task t1 = new Task(taskName, taskDetail);
        list.set(choice, t1);
        System.out.println("Printing out the Modified list: ");
        int j = 0;
        for (Task task : list) {
            System.out.println(j + ": Name - " + task.getTasksName());
            System.out.println(j + ": Detail - " + task.getTaskDetail());
            i++;
        }
        System.out.println("Task edited Successfully.");
    }

    public static void removeTask(ArrayList<Task> list) {
        System.out.println("Printing out your Tasklist: ");
        int i = 0;
        for (Task task : list) {
            System.out.println(i + ": " + task.getTasksName());
            i++;
        }
        int choice = 100;
        do {
            System.out.print("Please select the task that you would like to delete: ");
            choice = scan.nextInt();
            if (choice >= 0 && choice < list.size()) {
                break;
            } else {
                System.out.println("Invalid Choice. Please select a valid Task Number.");
                continue;
            }

        } while (true);
        list.remove(choice);
        System.out.println("Task Deleted Successfully.\nReturning to the main menu.");
    }

    public static void viewAllTasks(ArrayList<Task> taskList) {
        int count = 0;
        System.out.println("Printing out your TaskList: ");
        for (Task t1 : taskList) {
            System.out.println("--------------------");
            System.out.println(count + ". Task Name: " + t1.getTasksName());
            System.out.println(count + ". Task Detail: " + t1.getTaskDetail());
            System.out.println("--------------------");
            count++;
        }

    }

}
