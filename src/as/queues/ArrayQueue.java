package as.queues;

import as.lists.Employee;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if(back == queue.length) {
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = employee;
        // back is always points to the next available position
        back++;
    }

    public Employee remove() {
        // check if the queue is empty
        if(size() == 0) {
            throw new NoSuchElementException();
        }

        // otherwise, we save the employee at the front of the queue
        // we null out that position in the queue
        // and then we increment the front field
        Employee employee = queue[front];
        queue[front] = null;
        front++;
        // if there is nothing left on the queue then we set the front and back to 0 (reset the queue)
        if(size() == 0) {
            front = 0;
            back = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
 }
