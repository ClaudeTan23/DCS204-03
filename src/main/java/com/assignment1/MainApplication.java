package com.assignment1;

import java.util.Scanner;

public class MainApplication {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ListADT list = new ListADT();
    private static final StackADT stack = new StackADT();
    private static final QueueADT queue = new QueueADT();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========== ADT MENU ==========");
            System.out.println("1. List");
            System.out.println("2. Stack");
            System.out.println("3. Queue");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listMenu();
                    break;
                case 2:
                    stackMenu();
                    break;
                case 3:
                    queueMenu();
                    break;
                case 0:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    // ================= LIST =================

    private static void listMenu() {

        int choice;

        do {

            System.out.println("\n----- List ADT -----");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Get");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Is Empty");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    list.add(scanner.nextLine());
                    break;

                case 2:
                    System.out.print("Enter index: ");
                    list.remove(scanner.nextInt());
                    break;

                case 3:
                    System.out.print("Enter index: ");
                    System.out.println("Element: " + list.get(scanner.nextInt()));
                    break;

                case 4:
                    list.display();
                    break;

                case 5:
                    System.out.println("Size: " + list.size());
                    break;

                case 6:
                    System.out.println("Empty: " + list.isEmpty());
                    break;
            }

        } while (choice != 0);
    }

    // ================= STACK =================

    private static void stackMenu() {

        int choice;

        do {

            System.out.println("\n----- Stack ADT -----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Is Empty");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    stack.push(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Popped: " + stack.pop());
                    break;

                case 3:
                    System.out.println("Top: " + stack.peek());
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.println("Size: " + stack.size());
                    break;

                case 6:
                    System.out.println("Empty: " + stack.isEmpty());
                    break;
            }

        } while (choice != 0);
    }

    // ================= QUEUE =================

    private static void queueMenu() {

        int choice;

        do {

            System.out.println("\n----- Queue ADT -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Is Empty");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    queue.enqueue(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Dequeued: " + queue.dequeue());
                    break;

                case 3:
                    System.out.println("Front: " + queue.peek());
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println("Size: " + queue.size());
                    break;

                case 6:
                    System.out.println("Empty: " + queue.isEmpty());
                    break;
            }

        } while (choice != 0);
    }
}