# Assignment 1 - Implementation of Abstract Data Types (ADT) Using Java

## Overview

This project is developed for the **Data Structures and Algorithms** course.

The objective of this assignment is to demonstrate the implementation of fundamental **Abstract Data Types (ADT)** without using Java's built-in collection framework (such as `ArrayList`, `Stack`, or `Queue`).

The project implements the following ADTs from scratch using **dynamic arrays**:

* List ADT
* Stack ADT
* Queue ADT

A menu-driven console application is provided to allow users to interact with each data structure and test all required operations.

---

## Assignment Objectives

* Understand the concept of Abstract Data Types (ADT).
* Implement custom data structures without relying on Java Collection Framework.
* Apply Object-Oriented Programming (OOP) principles.
* Demonstrate the behavior of List, Stack, and Queue through a menu-driven application.
* Handle invalid operations gracefully (e.g., invalid index, stack underflow, queue underflow).

---

## Features

### List ADT

Supported operations:

* Add element
* Remove element by index
* Get element by index
* Display all elements
* Check size
* Check whether the list is empty

---

### Stack ADT (LIFO)

Supported operations:

* Push
* Pop
* Peek
* Display stack
* Check size
* Check whether the stack is empty

---

### Queue ADT (FIFO)

Supported operations:

* Enqueue
* Dequeue
* Peek
* Display queue
* Check size
* Check whether the queue is empty

---

## Project Structure

```text
assignment1
│
├── pom.xml
│
└── src
    └── main
        └── java
            └── com
                └── assignment1
                    ├── MainApplication.java
                    ├── ListADT.java
                    ├── StackADT.java
                    └── QueueADT.java
```

---

## Technologies Used

* Java 17
* Apache Maven 3.9.9

---

## Requirements

Install the following before running the project:

* Java Development Kit (JDK) 17
* Apache Maven 3.9.9 or newer

Verify installation:

```bash
java -version
```

```bash
mvn -version
```

---

## Build the Project

Clean the previous build and compile the source code:

```bash
mvn clean compile
```

---

## Run the Application (Recommended)

Run the application using the Maven Exec Plugin:

```bash
mvn exec:java
```

---

## Alternative: Run Without Maven

Compile the project first:

```bash
mvn clean compile
```

Then execute the compiled classes directly:

### Windows

```bash
java -cp target/classes com.assignment1.MainApplication
```

### Linux / macOS

```bash
java -cp target/classes com.assignment1.MainApplication
```

---

## Package the Project

Create the JAR file:

```bash
mvn package
```

The generated JAR will be located in:

```text
target/
```

---

## Example Menu

```text
========== ADT MENU ==========
1. List
2. Stack
3. Queue
0. Exit
```

Each ADT contains its own submenu to perform the required operations.

---

## Data Structure Implementation

This project implements all data structures using **dynamic arrays**.

Characteristics:

* No Java Collection Framework is used.
* Arrays automatically resize when capacity is reached.
* Encapsulation is applied to each ADT.
* Error handling is included for invalid operations.
