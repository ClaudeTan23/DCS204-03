package com.assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApplication {

    private static final Scanner scanner = new Scanner(System.in);

    private static final BST bst = new BST();
    private static final Graph graph = new Graph();

    public static void main(String[] args) {

        int choice = -1;

        do {

            try {

                System.out.println("\n=================================");
                System.out.println(" Trees and Graphs");
                System.out.println("=================================");
                System.out.println("1. Binary Search Tree");
                System.out.println("2. Graph");
                System.out.println("0. Exit");
                System.out.print("Choice : ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        bstMenu();
                        break;

                    case 2:
                        graphMenu();
                        break;

                    case 0:
                        System.out.println("\nProgram terminated.");
                        break;

                    default:
                        System.out.println("Invalid choice.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();

            }

        } while (choice != 0);

    }

    // ==========================================================
    // BST MENU
    // ==========================================================

    private static void bstMenu() {

        int choice = -1;

        do {

            try {

                System.out.println("\n========== BINARY SEARCH TREE ==========");
                System.out.println("1. Insert Value");
                System.out.println("2. Delete Value");
                System.out.println("3. Search Value");
                System.out.println("4. Find Minimum");
                System.out.println("5. Find Maximum");
                System.out.println("6. Display Traversals");
                System.out.println("7. Display Tree Properties");
                System.out.println("0. Back");
                System.out.print("Choice : ");

                choice = scanner.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter value : ");
                        bst.insert(scanner.nextInt());
                        System.out.println("Value inserted successfully.");
                        break;

                    case 2:

                        System.out.print("Enter value : ");
                        bst.delete(scanner.nextInt());
                        break;

                    case 3:

                        System.out.print("Enter value : ");

                        int search = scanner.nextInt();

                        if (bst.search(search)) {
                            System.out.println(search + " exists in the tree.");
                        } else {
                            System.out.println(search + " not found.");
                        }

                        break;

                    case 4:

                        try {
                            System.out.println("Minimum Value : " + bst.findMin());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case 5:

                        try {
                            System.out.println("Maximum Value : " + bst.findMax());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case 6:

                        bst.displayTraversals();
                        break;

                    case 7:

                        bst.displayProperties();
                        break;

                    case 0:

                        break;

                    default:

                        System.out.println("Invalid choice.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input.");
                scanner.nextLine();

            }

        } while (choice != 0);

    }

    // ==========================================================
    // GRAPH MENU
    // ==========================================================

    private static void graphMenu() {

        int choice = -1;

        do {

            try {

                System.out.println("\n=============== GRAPH ===============");
                System.out.println("1. Add Vertex");
                System.out.println("2. Add Edge");
                System.out.println("3. Display Graph");
                System.out.println("4. Breadth First Search (BFS)");
                System.out.println("5. Depth First Search (DFS)");
                System.out.println("6. Dijkstra Shortest Path");
                System.out.println("7. Prim Minimum Spanning Tree");
                System.out.println("0. Back");
                System.out.print("Choice : ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Vertex Name : ");
                        String vertex = scanner.nextLine();

                        graph.addVertex(vertex);

                        break;

                    case 2:

                        System.out.print("Source Vertex : ");
                        String source = scanner.nextLine();

                        System.out.print("Destination Vertex : ");
                        String destination = scanner.nextLine();

                        System.out.print("Weight : ");
                        int weight = scanner.nextInt();
                        scanner.nextLine();

                        graph.addEdge(source, destination, weight);

                        break;

                    case 3:

                        graph.displayGraph();

                        break;

                    case 4:

                        System.out.print("Starting Vertex : ");
                        graph.bfs(scanner.nextLine());

                        break;

                    case 5:

                        System.out.print("Starting Vertex : ");
                        graph.dfs(scanner.nextLine());

                        break;

                    case 6:

                        System.out.print("Source Vertex : ");
                        graph.dijkstra(scanner.nextLine());

                        break;

                    case 7:

                        graph.primMST();

                        break;

                    case 0:

                        break;

                    default:

                        System.out.println("Invalid choice.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input.");
                scanner.nextLine();

            }

        } while (choice != 0);

    }

}