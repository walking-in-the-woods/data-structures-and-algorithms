package as.queues;

// 0 - jane - front
// 1 - john
// 2 - mary
// 3 - mike
// 4         - back

// 0
// 1 - john - front
// 2         - back
// 3
// 4

// 0
// 1
// 2 - mary - front
// 3         - back
// 4

// 0         - back
// 1
// 2
// 3 - mike - front
// 4 - bill

// 0 - jane
// 1 - john
// 2 -      - back      <- so, there is no space anymore
// 3 - mike - front
// 4 - bill

// 0 - mike - front     <- now we place front elements at the beginning of the array
// 1 - bill
// 2 - jane             <- we place other elements just after
// 3 - john
// 4       - back
// 5                    <- and there are left the empty places because of the resizing of the array
// ...
// 9

import as.lists.Employee;

import java.util.NoSuchElementException;

public class CircularQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public CircularQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[2 * queue.length];

            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);

            queue = newArray;

            front = 0;
            back = numItems;
        }

        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        }
        else {
            back = 0;
        }
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        else if (front == queue.length) {
            front = 0;
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
        if (front <= back) {
            return back - front;
        }
        else {
            return back - front + queue.length;
        }

    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
