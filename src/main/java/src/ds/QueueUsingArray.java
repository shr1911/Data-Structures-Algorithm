package src.ds;

import java.util.Arrays;

public class QueueUsingArray {

    private final int size = 5;
    private final int[] arr;
    private int front = -1;
    private int rear = -1;

    public QueueUsingArray() {
        arr = new int[size];
    }

    public void enqueue(int data) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (isFull()) {
            System.out.println("Queue is full");
            return;
        } else {
            rear = (rear + 1) % size;
        }
        arr[rear] = data;
    }

    public int front() {
        return arr[front];
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            arr[front] = 0;
            front = (front + 1) % size;
        }

    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void print() {
        System.out.println("Queue: " + Arrays.toString(arr) + " Front: " + front + " Rear: " + rear);
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();
        queue.enqueue(7);
        queue.print();
        queue.enqueue(3);
        queue.print();
        queue.enqueue(1);
        queue.print();
        queue.enqueue(9);
        queue.print();
        queue.enqueue(10);
        queue.print();
        queue.enqueue(4);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(6);
        queue.print();
        queue.enqueue(2);
        queue.print();
        System.out.println("Front: " + queue.front());
        queue.dequeue();
        queue.print();
    }
}