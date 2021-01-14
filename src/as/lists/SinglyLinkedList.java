package as.lists;

// HEAD -> "Jane" -> "John" -> "Mary" -> "Mike" -> null
// Using a LinkList we have to store not only values but references as well
// HEAD -> "Bill" -> Jane" -> "John" -> "Mary" -> "Mike" -> null
// removedNode:"Bill" <- HEAD -> "Jane" -> "John" -> "Mary" -> "Mike" -> null
// Addition dnd Removing time complexity in front of the list is O(1) (there is no shifting)
// Insertion and Removing at the body of a list performs in linear time 0(n)

// There is also a CircularLinkedList which is a variation of a SinglyLinkedList
// In this variation the last node in the list doesn't point to null
// Instead, it points to the head of the list
// And one advantage to this is that we can traverse the entire list starting at any node

public class SinglyLinkedList {
    public static void main(String[] args) {

        Employee janeJons = new Employee("Jane", "Jones", 123);
        Employee johnDoe= new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJons);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.getSize());

        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }
}
