package as.stacks;

/*
 Abstract data type
 LIFO - Last in, first out
 push - adds an item as the top item on the stack
 pop - removes the top item on the stack
 peek - gets the top item on the stack
 Ideal backing data structure: LinkedList
 Stack is the perfect data structure for a Call Stack
*/

/*
 Time Complexity:
 O(1) for push, pop, and peek, when using a LinkedList
 O(n) for push when using an Array because the array may have to be resized
 If we know the maximum number of items that will ever bo on the stack, an array can be a good choice
 If memory is tight, an array might be a good choice
*/

import as.lists.Employee;

public class StackMain {
    public static void main(String[] args) {
//        // Array stack implementation
//
//        ArrayStack stack = new ArrayStack(10);
//
//        stack.push(new Employee("Jane", "Jones", 123));
//        stack.push(new Employee("John", "Doe", 4567));
//        stack.push(new Employee("Mary", "Smith", 22));
//        stack.push(new Employee("Mike", "Wilson", 3245));
//        stack.push(new Employee("Bill", "End", 78));
//
//        //stack.printStack();
//
//        System.out.println(stack.peek());
//        //stack.printStack();
//
//        System.out.println("Popped: " + stack.pop());
//        System.out.println(stack.peek());

        // LinkedList stack implementation

        Employee janeJons = new Employee("Jane", "Jones", 123);
        Employee johnDoe= new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedStack stack = new LinkedStack();

        stack.push(janeJons);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);

        //stack.printStack();

        //System.out.println(stack.peek());
        //stack.printStack();

        System.out.println("Popped: " + stack.pop());
        System.out.println(stack.peek());

    }
}
