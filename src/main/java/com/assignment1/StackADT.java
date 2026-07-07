package com.assignment1;

public class StackADT {

    private String[] stack;
    private int top;

    public StackADT() {
        stack = new String[5];
        top = -1;
    }

    private void resize() {

        String[] newStack = new String[stack.length * 2];

        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    public void push(String element) {

        if (top + 1 == stack.length) {
            resize();
        }

        stack[++top] = element;
    }

    public String pop() {

        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            return null;
        }

        String value = stack[top];
        stack[top] = null;
        top--;

        return value;
    }

    public String peek() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}