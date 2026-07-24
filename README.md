# Assignment 2 – Trees and Graphs Implementation

A Java console application that demonstrates the implementation of **Binary Search Tree (BST)** and **Graph** data structures without using Java's built-in Tree or Graph libraries.

This project is developed as part of the **Data Structures and Algorithms** course to demonstrate the understanding of tree operations, graph traversal algorithms, shortest path algorithms, and minimum spanning tree algorithms.

---

# Features

## Part A – Binary Search Tree (BST)

### BST Core Operations

- Insert node
- Search node
- Delete node
- Find Minimum
- Find Maximum

### Tree Traversals

- Inorder Traversal
- Preorder Traversal
- Postorder Traversal

### Tree Properties

- Tree Height
- Total Number of Nodes
- Number of Leaf Nodes

---

## Part B – Graph

The graph is implemented using an **Adjacency List**.

### Graph Representation

- Add Vertex
- Add Edge (Weighted)
- Display Graph

### Graph Traversals

- Breadth First Search (BFS)
- Depth First Search (DFS)

### Shortest Path

- Dijkstra's Algorithm

### Minimum Spanning Tree

- Prim's Algorithm

---

# Project Structure

```
src
└── com
    └── assignment2
        ├── MainApplication.java
        ├── BST.java
        ├── TreeNode.java
        └── Graph.java
```

---

# Requirements

- Java 17 or newer
- Apache Maven 3.9.9 or newer

Verify your installation:

```bash
java -version
```

```bash
mvn -version
```

---

# Build and Run
Using Maven (Recommended)

Clean and compile the project.

```bash
mvn clean compile
```

Run the application.

```bash
mvn exec:java
```

---

# Assignment Objectives

This assignment demonstrates the implementation of fundamental Tree and Graph algorithms without relying on Java's built-in data structures.

## Binary Search Tree

- Build a Binary Search Tree
- Perform insertion, searching and deletion
- Find minimum and maximum values
- Traverse the tree using three traversal methods
- Calculate tree properties

## Graph

- Implement an adjacency list graph
- Perform Breadth First Search (BFS)
- Perform Depth First Search (DFS)
- Compute shortest paths using Dijkstra's Algorithm
- Generate a Minimum Spanning Tree using Prim's Algorithm

---

## Graph

1. Add vertices.
2. Connect vertices using weighted edges.
3. Display the graph.
4. Perform BFS.
5. Perform DFS.
6. Find shortest paths using Dijkstra's Algorithm.
7. Generate a Minimum Spanning Tree using Prim's Algorithm.

---

# Source Code

The following Java source files are included in this project:

```text
MainApplication.java
BST.java
TreeNode.java
Graph.java
```
