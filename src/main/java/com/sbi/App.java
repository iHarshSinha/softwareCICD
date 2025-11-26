package com.sbi;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TODO APP =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter task: ");
                String task = sc.nextLine();
                tasks.add(task);
                System.out.println("Task added.");

            } else if (choice == 2) {
                System.out.println("\nYour Tasks:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + ": " + tasks.get(i));
                }

            } else if (choice == 3) {
                System.out.print("Enter task index to remove: ");
                int index = sc.nextInt();
                if (index >= 0 && index < tasks.size()) {
                    tasks.remove(index);
                    System.out.println("Task removed.");
                } else {
                    System.out.println("Invalid index.");
                }

            } else if (choice == 4) {
                System.out.println("Bye!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}