package as.hashtables;

// Common strategies for handling collisions:
// 1. Open addressing: if the address is not empty we are looking for another one
// We're going to use Linear Probing for this.
// When wew find that an address is occupied, we increment the hashed value by 1
// 2. Chaining: instead of storing the value directly int the array, each array position
// contains a linked list. See the ChainedHashtable class.
// On average, linear probing performs better than chaining does.
// But chaining implementation is a little bit simpler.

import as.lists.Employee;

public class SimpleHashtable {

    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
             int stopIndex = hashedKey;
             if (hashedKey == hashtable.length - 1) {
                 hashedKey = 0;
             } else {
                 hashedKey++;
             }

             while (occupied(hashedKey) && hashedKey != stopIndex) {
                 hashedKey = (hashedKey + 1) % hashtable.length;
             }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    // O(1) time complexity
    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                // rehash hashtable to avoid null pointing when we remove an item
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }

        return employee;
    }

    private int hashKey(String key) {
       return key.length() % hashtable.length;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i=0; i < hashtable.length; i++) {
            if (hashtable[i] == null)  {
                System.out.println("empty");
            } else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }
}
