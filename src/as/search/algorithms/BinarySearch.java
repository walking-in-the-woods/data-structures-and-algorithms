package as.search.algorithms;

// Data must be sorted!
// Cheeses the element in the middle of the array and compares it against the search value
// If element is equal to the value, we're done
// If element is greater than the value, search the left half of the array
// If the element is less than the value, search the right half of the array

// { -22, -15, 1, 7, 20, 35, 55 } original sorted array
// Search value: 1
// start = 0, end = 7, midpoint = (start + end)/2 = 3
// array[3] = 7 - this is greater than 1, so we'll look at the left half of the array
// start = 0, end = midpoint = 3, midpoint = (start + end)/2 = 1
// array[1] = -15 - this is less than 1, so we'll look at the right half of the array
// start = midpoint + 1 = 2, end = 3, midpoint = (start + end)/2 = 2
// array[2] = 1 - we have found our value

// At some point, there will be only one element in the partition we're checking,
// but it doesn't have to get to that point
// Can be implemented recursively
// O(logn) - keeps dividing the array in half

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = { -22, -15, 1, 7, 20, 35, 55 };

        System.out.println(iterativeBinarySearch(intArray, -15));
        System.out.println(iterativeBinarySearch(intArray, 35));
        System.out.println(iterativeBinarySearch(intArray, 8888));
        System.out.println(iterativeBinarySearch(intArray, 1));

//        System.out.println(recursiveBinarySearch(intArray, -15));
//        System.out.println(recursiveBinarySearch(intArray, 35));
//        System.out.println(recursiveBinarySearch(intArray, 8888));
//        System.out.println(recursiveBinarySearch(intArray, 1));
    }

    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            System.out.println("midpoint = " + midpoint);
            if (input[midpoint] == value) {
                return value;
            } else if (input[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }

        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;
        System.out.println("midpoint = " + midpoint);

        if (input[midpoint] == value) {
            return midpoint;
        } else if (input[midpoint] < value) {
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        } else {
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }
}
