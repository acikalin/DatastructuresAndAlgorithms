package com.coding.datastructures;

import com.coding.datastructures.exceptions.StackUnderFlowException;

public class Stack<T> {

    private Node<T> head = null;
    private int size = 0;
    private static int INT_MAX_SIZE = 40;

    public void push(T data) {
        if (INT_MAX_SIZE > size) {
            if (head == null) {
                head = new Node<>(data);
            } else {
                Node<T> curr = head;
                head = new Node<>(data);
                head.setNext(curr);
            }
            size++;
        } else {
            throw new StackOverflowError();
        }

    }

    public T pop() throws StackUnderFlowException {
        if (head == null) {
            throw new StackUnderFlowException();
        }
        T popData = head.getData();
        head = head.getNext();
        size--;
        return popData;
    }

    public T peek() throws StackUnderFlowException {
        if (head == null) {
            throw new StackUnderFlowException();
        }
        return head.getData();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return INT_MAX_SIZE == size;
    }

    public String toString() {
        if (head == null) {
            return null;
        }
        Node<T> curr = head;
        StringBuilder sb = new StringBuilder();

        while (curr != null) {
            sb.append(curr.getData());
            curr = curr.getNext();
        }
        return sb.toString();
    }
}
