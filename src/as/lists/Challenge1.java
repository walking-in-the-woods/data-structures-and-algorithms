package as.lists;

// Add addBefore() method to the DoublyLinkedList class

public class Challenge1 {
    public static void main(String[] args) {

        Employee janeJons = new Employee("Jane", "Jones", 123);
        Employee johnDoe= new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(janeJons);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        list.printList();

        list.addBefore(billEnd, johnDoe);
        list.printList();

        list.addBefore(new Employee("Someone", "Else", 1111), mikeWilson);
        list.printList();
    }
}
