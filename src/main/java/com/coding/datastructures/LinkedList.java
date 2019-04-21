package com.coding.datastructures;

public class LinkedList<T> {

    private Node<T> head;

    public void push(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node<>(data));
        }
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        T currData = head.getData();
        head = head.getNext();
        return currData;
    }


    public T peek() {
        if (head == null) {
            return null;
        } else {
            return head.getData();
        }
    }

    public void remove() {
        if (head != null) {
            head = head.getNext();
        }
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
