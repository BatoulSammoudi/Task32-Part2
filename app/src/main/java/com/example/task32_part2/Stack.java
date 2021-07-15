package com.example.task32_part2;

public class Stack {
    final int MAX_SIZE = 100;
    int top;
    char array[];

    public Stack() {
        this.top = -1;
        this.array = new char[MAX_SIZE];
    }

    public void push(char a) {
        if (top >= MAX_SIZE - 1) {
            return;
        } else {
            array[++top] = a;
        }
    }

    public char pop() {
        if (top < 0) {
            return ' ';
        } else {
            char a = array[top--];
            return a;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else
            return false;
    }

    public char peek() {
        if (top < 0) {
            return ' ';
        } else {
            return array[top];
        }
    }
}
