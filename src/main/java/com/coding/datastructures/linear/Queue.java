package com.coding.datastructures.linear;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> head, tail;
    private int size = 0;

    public void enqueue(T data){
        if(isEmpty()){
            head = new Node<>(data);
            tail = head;
        }else{
            Node<T> lastOld = tail;
            tail = new Node<>(data);
            lastOld.setNext(tail);
        }
        size++;
    }

    public T dequeue(){
        T currData = head.getData();
        head = head.getNext();
        size--;
        return currData;

    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return head.getData();
    }


    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

}
