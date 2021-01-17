package as.hashtables;

// Abstract data type
// Provide access to data using keys
// Key doesn't have to be an integer
// Consists of key/value pairs - data types don't have to match
// Optimized for retrieval (when you know the key)
// Associative array is one type of hash table

// Load Factor
// Tells us how full a hash table is
// Load factor = # of items / capacity = size / capacity
// Load factor is used to decide when to resize the array backing the hash table
// Don't want load factor too low (lots of empty space)
// Don't want load factor too high (will increase the likelihood of collisions)
// Can play a role in determining the time complexity for retrieval

// Add to a Hash Table backed by an array
// 1. Provide a key/value pair
// 2. Use a hash function to hash the key to an int value
// 3. Store the value at the hashed key value - this is the index into the array

// Retrieve a value from a hash table
// 1. Provide the key
// 2. Use the same hash function to hash the key to an int value
// 3. Retrieve the value stored at the hashed key value

// Add "Jane Jones" with key of "Jones"
// 1. Use a hash function to map "Jones" to an int - let's assume we get the value 4
// 2. Store "Jane Jones" at array[4]

// Retrieve the employee with key "Jones"
// 1. Provide the key "Jones"
// 2. Use a hash function to map "Jones" to an int - let's assume we get the value 4
// 3. Retrieve the value at array[4] -> "Jane Jones"

// JDK implementation of a HashTable is an interface Map<K,V>
// HashMap<K,V> is the implementation of the Map<K,V> interface

import as.lists.Employee;

import java.util.HashMap;
import java.util.Map;

public class HashtableMain {
    public static void main(String[] args) {

        Employee janeJons = new Employee("Jane", "Jones", 123);
        Employee johnDoe= new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        // Linear Probing implementation
        //SimpleHashtable ht = new SimpleHashtable();
        // Chaining implementation
//        ChainedHashtable ht = new ChainedHashtable();
//        ht.put("Jones", janeJons);
//        ht.put("Doe", johnDoe);
//        ht.put("Wilson", mikeWilson);
//        ht.put("Smith", marySmith);
//        //ht.put("End", billEnd);
//
//        ht.printHashtable();

//        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
//
//        ht.remove("Wilson");
//        ht.remove("Jones");
//        ht.printHashtable();
//
//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

        // JDK Collections implementation
        Map<String, Employee> hashMap = new HashMap<String, Employee>();

        hashMap.put("Jones", janeJons);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
        //hashMap.put("Doe", mikeWilson); // this will override the "Doe" value
        hashMap.putIfAbsent("Doe", mikeWilson); // this will not

        System.out.println(hashMap.get("Smith"));
        System.out.println(hashMap.get("someone"));
        System.out.println(hashMap.getOrDefault("someone", mikeWilson));
        System.out.println(hashMap.remove("Jones"));

//        // this will be fast because we know the key
//        System.out.println(hashMap.containsKey("Doe"));
//        // this will be slow because we don't know the key and need to search the value
//        System.out.println(hashMap.containsValue(janeJons));

//        Iterator<Employee> iterator = hashMap.values().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }
}
