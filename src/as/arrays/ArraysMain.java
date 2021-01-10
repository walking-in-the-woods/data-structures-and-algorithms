package as.arrays;

// Te best characteristic of an array is a fast retrieving an element if we know it's index

public class ArraysMain {
    public static void main(String[] args) {
        int[] intArray = new int[7];

        // Start address of array = 12, element size = 4 bites

        intArray[0] = 20; // 12 + (0 * 4) = 12
        intArray[1] = 35; // 12 + (1 * 4) = 16
        intArray[2] = -15; // 12 + (2 * 4) = 20
        intArray[3] = 7; // 12 + (3 * 4) = 24
        intArray[4] = 55; // 12 + (4 * 4) = 28
        intArray[5] = 1; // 12 + (5 * 4) = 32
        intArray[6] = -22; // 12 + (6 * 4) = 36

        // print the array
        for(int i =0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        // find an index of the value 7
        int index = -1;
        for(int i =0; i < intArray.length; i++) {
            if(intArray[i] == 7){
                index = i;
                break;
            }
        }
        System.out.println("index = " + index);

        /* If an array starts at memory address x, and the size of each element in the array is y,
        we can calculate the memory address of the i'th element by using an expression: x + i * y
        So, if we know the index af an element, the time to retrieve the element wil be the same
         */

        /* Time complexity of the operations:
        1. Retrieve with index - O(1) - Constant time
        2. Retrieve without index - O(n) - Linear time (because we should loop over the array)
        3. Add an element to a full array - 0(n) (because we should copy an array and fill it with elements)
        4. Add an element to the end of an array (has space) - O(1)
        5. Insert or update an element at a specific index - O(1)
        6. Delete an element by setting it to null - O(1)
        7. Delete an element by shifting elements - O(n)
         */

        // So, if we HAVE TO LOOP OVER an array we get O(n) time complexity,
        // if we don't have to do it we get O(1) time complexity
    }
}
