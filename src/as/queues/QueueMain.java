package as.queues;

// Abstract data type
// FIFO - first in, first out
// add - also called  enqueue - add an item to the end of the queue
// remove - also called dequeue - remove an item at the front of the queue
// peek - get the item at the front of the queue, but don't remove it

// Time Complexity:
// O(1) for push, pop, and peek, when using a LinkedList
// O(n) for push when using an Array because the array may have to be resized

// JDK Queue<E>
// DoublyLinkedList is perfect for queue implementation
// Dequeue<E> supports element insertion and removal at both ends.
// "dequeue" is short from "double ended queue" and is usually pronounced "deck"

import as.lists.Employee;

public class QueueMain {
    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe= new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

//        ArrayQueue queue = new ArrayQueue(10);
        CircularQueue queue = new CircularQueue(5);

//        queue.add(janeJones);
//        queue.add(johnDoe);
//        queue.add(marySmith);
//        queue.add(mikeWilson);
//        queue.add(billEnd);
//        //queue.printQueue();
//
//        queue.remove();
//        queue.remove();
//        //queue.printQueue();
//
//        //System.out.println(queue.peek());
//        //queue.printQueue();
//
//        queue.remove();
//        queue.remove();
//        queue.remove();
//        //queue.remove();
//
//        queue.add(mikeWilson);
//        queue.printQueue();

        queue.add(janeJones);
        queue.add(johnDoe);
        queue.remove();
        queue.add(marySmith);
        queue.remove();
        queue.add(mikeWilson);
        queue.remove();
        queue.add(billEnd);
        queue.remove();
        queue.add(janeJones);

        queue.printQueue();
    }
}
