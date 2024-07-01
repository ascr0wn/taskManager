package main;

import features.UserOperations;
import model.Login;
import model.Registration;
import model.Task;

import java.util.*;

public class App {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int countForRegistration = 0;
        ArrayList<Registration> userRegistrationData = new ArrayList<>();
        int countForLogin = 0;
        ArrayList<Login> userLoginData = new ArrayList<>();
        int countForTask = 0;
        ArrayList<ArrayList<Task>> userTaskData = new ArrayList<>();
        System.out.println(
                "********************\nWelcome to our Task Manager Application\n********************\nWhat would you like to do.");
        int choice = 0;

        do {
            System.out.println("1. Login\n2. Registration\n3. Close Application");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            if (choice == 1) { // LOGIN
                System.out.println("--------------------");
                System.out.println("You selected Login.");
                System.out.println("--------------------");
                System.out.print("Please enter your Email: ");
                String email;
                email = scan.next();
                int idNumber = loginVerification(email, userLoginData);
                int taskMenuChoice;
                if (idNumber == -1) {
                    continue;
                } else {
                    while (true) {

                        System.out.print(
                                "What would you like to do\n1. Add a Task\n2. Delete a Task\n3. List all tasks\n4. Edit a Task\n5. Exit Menu\nSelect your option: ");
                        taskMenuChoice = scan.nextInt();
                        if (taskMenuChoice == 1) {
                            System.out.println("You chose to Add a Task.");
                            userTaskData.get(idNumber).add(UserOperations.addTask());
                            System.out.println("Task Added Successfully.\nReturning to the Main Menu.");
                            continue;
                        } else if (taskMenuChoice == 2) {
                            System.out.println("You Selected Delete a Task.");
                            UserOperations.removeTask(userTaskData.get(idNumber));
                            continue;
                        } else if (taskMenuChoice == 3) {
                            UserOperations.viewAllTasks(userTaskData.get(idNumber));
                            continue;
                        } else if (taskMenuChoice == 4) {
                            System.out.println("You Selected Edit a Task.");
                            UserOperations.editTask(userTaskData.get(idNumber));
                            continue;
                        } else if (taskMenuChoice == 5) {
                            System.out.println("Thank you for using our application. Exiting Now.");
                            break;
                        } else {
                            System.out.println("Invalid Choice. Please enter a valid number from the Menu List.");
                            continue;
                        }

                    }
                }

            } else if (choice == 2) { // REGISTRATION
                System.out.println("--------------------");
                System.out.println("You selected Registration");
                System.out.println("--------------------");
                System.out.print("Please Enter your name: ");
                String name = scan.next();
                System.out.print("Please enter your Phone Number: ");
                long phNum = scan.nextLong();
                System.out.print("Please Enter a your Email: ");
                String email = scan.next();
                System.out.print("Please enter a password: ");
                String password = scan.next();
                userRegistrationData.add(countForRegistration, new Registration(phNum, name, email, password));
                countForRegistration++;
                userLoginData.add(countForLogin, new Login(email, password));
                countForLogin++;
                userTaskData.add(new ArrayList<Task>());
                countForTask++;
                System.out.println("You are successfully Registered. Now you can Log In from the Main Menu.");
                continue;

            } else if (choice == 3) { // EXIT
                System.out.println("Thank you for using our Application.\nTerminating now.");
                break;
            } else { // INVALID
                System.out.println("Invalid choice");
                continue;
            }
        } while (true);
    }

    public static int loginVerification(String email, ArrayList<Login> userLoginData) {
        // Scanner scan = new Scanner(System.in);
        for (int i = 0; i < userLoginData.size(); i++) {
            if (email.equals(userLoginData.get(i).getEmail())) {
                System.out.print("User with email '" + email + "' found.\n");
                String password;
                while (true) {
                    System.out.print("Please enter your password now: ");
                    password = scan.next();
                    if (password.equals(userLoginData.get(i).getPassword())) {
                        System.out.println("Your entered password is correct.\nYou are successfully logged in.");
                        return i;
                    } else {
                        System.out.println("Wrong Password. Try Again.");
                        continue;
                    }

                }
            }

        }
        scan.close();
        
        System.out.println(
                "Your entered email is incorrect. Please try again and make sure you are registered first.");
        return -1;
    }
}