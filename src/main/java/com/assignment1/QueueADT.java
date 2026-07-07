package com.assignment1;

public class QueueADT {

    private String[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueADT() {
        queue = new String[5];
        front = 0;
        rear = -1;
        size = 0;
    }

    private void resize() {

        String[] newQueue = new String[queue.length * 2];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }

        queue = newQueue;
        front = 0;
        rear = size - 1;
    }

    public void enqueue(String element) {

        if (size == queue.length) {
            resize();
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    public String dequeue() {

        if (isEmpty()) {
            System.out.println("Queue Underflow.");
            return null;
        }

        String value = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return value;
    }

    public String peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(queue[(front + i) % queue.length]);
        }
    }

}