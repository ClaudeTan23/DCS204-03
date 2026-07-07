package com.assignment1;

public class ListADT {

    private String[] data;
    private int size;

    public ListADT() {
        data = new String[5];
        size = 0;
    }

    private void resize() {
        String[] newData = new String[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public void add(String element) {

        if (size == data.length) {
            resize();
        }

        data[size] = element;
        size++;
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
    }

    public String get(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return null;
        }

        return data[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + data[i]);
        }
    }

}