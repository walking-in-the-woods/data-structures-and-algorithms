package as.hashtables;

// The worst case for chaining is linear time O(n) (if we use really bad hashing function
// and every single key hashed tho the sane value. In this case every single item is going to be
// put into the linked list at the same position an so, when we retrieve something
// we potentially have to traverse every single item in the hashtable
// The average case is: if "k" is the maximum length of a linked list in the hashtable,
// the time complexity is O(1 + k)
// Time complexity depends on the hashing function and on the load factor.

import as.lists.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()) {
            employee = iterator.next();
            if (employee.key.equals(key)) {
                return employee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while (iterator.hasNext()) {
            employee = iterator.next();
            index++;
            if (employee.key.equals(key)) {
                break;
            }
        }

        if (employee == null || !employee.key.equals(key)) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    private int hashKey(String key) {
        //return key.length() % hashtable.length;
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void printHashtable() {
        for (int i=0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
            } else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().employee);
                    System.out.print(" -> ");
                }
                System.out.println("null");
            }
        }
    }
}
