package as.lists;

import java.util.Iterator;
import java.util.LinkedList;

public class JDKLists {
    public static void main(String[] args) {

        Employee janeJons = new Employee("Jane", "Jones", 123);
        Employee johnDoe= new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(janeJons);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        printList(list);

        list.addLast(billEnd);
        printList(list);

        list.removeFirst();
        printList(list);

        list.removeLast();
        printList(list);

//        for(Employee employee: list) {
//            System.out.println(employee);
//        }
    }

    private static void printList(LinkedList<Employee> list) {
        System.out.println("------------------------------");
        Iterator i = list.iterator();
        System.out.print("HEAD -> ");
        while(i.hasNext()) {
            System.out.print(i.next());
            System.out.print(" <=> ");
        }
        System.out.print("null\n");
        System.out.println("------------------------------");
    }
}
