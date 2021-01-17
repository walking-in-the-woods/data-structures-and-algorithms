package as.hashtables;

// Remove duplicate items from a linked list
// A solution must use the JDK's LinkedList class
// A solution must use a HashMap

import as.lists.Employee;

import java.util.*;

public class Challenge2 {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 4567));
        employees.add(new Employee("Mary", "Smith", 22));
        employees.add(new Employee("John", "Doe", 4567));
        employees.add(new Employee("Mike", "Wilson", 3245));
        employees.add(new Employee("Bill", "End", 78));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));

        HashMap<Integer, Employee> employeeTable = new HashMap<>();
        ListIterator<Employee> iterator = employees.listIterator();
        List<Employee> remove = new ArrayList<>();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employeeTable.containsKey(employee.getId())) {
                remove.add(employee);
                // employees.remove(employee); don't do this. it throws ConcurrentModificationException
            } else {
                employeeTable.put(employee.getId(), employee);
            }
        }

        for (Employee employee: remove) {
            employees.remove(employee);
        }

        System.out.println("----------------------------------------------------");
        employees.forEach(e -> System.out.println(e));
    }
}
