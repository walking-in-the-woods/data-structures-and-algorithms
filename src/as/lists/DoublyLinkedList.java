package as.lists;

// null/HEAD <- "Jane" <-> "John" <-> "Mary" <-> "Mike" -> null/TAIL
// Addition and Removing operations at the head and tail performs in CONSTANT time O(1)
// Insertion and Removing at the body of a list performs in linear time 0(n) because we need to find a node first

public class DoublyLinkedList {
    public static void main(String[] args) {

        Employee janeJons = new Employee("Jane", "Jones", 123);
        Employee johnDoe= new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(janeJons);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        list.printList();
        System.out.println(list.getSize());

        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();

        list.printList();
        System.out.println(list.getSize());

        list.removeFromEnd();

        list.printList();
        System.out.println(list.getSize());
    }
}
