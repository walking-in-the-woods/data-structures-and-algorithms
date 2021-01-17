package as.hashtables;

// Uses hashing
// Makes assumptions about the data, like radix and counting sort
// Because it makes assumptions, can sort in 0(n) time
// Performs best when hashed values of items being sorted are evenly distributed,
// so there aren't many collisions

// 1. Distribute the items into buckets based on their hashed values (scattering phase)
// 2. Sort the items in each bucket
// 3. Merge the buckets - can just concatenate them (gathering phase)

// A generation og counting sort

// The values in bucket X must be greater than the values in bucket X-1
// and less than the values in bucket X + 1
// this means that the hash function we use must meet this requirement

// {54, 46, 83, 66, 95, 92, 43} original array
// {x, x, x, x, 46 -> 43, 54, 66, x, 83, 95 -> 92} buckets, scattering phase
// {x, x, x, x, 43 -> 46, 54, 66, x, 83, 92 -> 95} buckets, sorting phase
// {43, 46, 54, 66, 83, 92, 95} sorted array, gathering phase

// NOT in-place algorithm
// Stability will depend on sort algorithm used to sort the buckets - ideally, it should be a stable sort
// To achieve O(n) time complexity, we must have only the one item per bucket
// Insertion sort is often used to sort the buckets, because it is fast when the number of items is small

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] intArray = {54, 46, 83, 66, 95, 92, 43};

        bucketSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void bucketSort(int[] input) {
        // we can choose the type of a List later
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            // using array lists for the buckets
            buckets[i] = new ArrayList<Integer>();

            // using linked lists for the buckets
            //buckets[i] = new LinkedList<Integer>();
        }

        // scattering values
        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        for (List bucket: buckets) {
            // this uses a merge sort
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value: buckets[i]) {
                input[j++] = value;
            }
        }
    }

    private static int hash(int value) {
        // division runs first, then we modded it by 10
        return value / (int) 10 %  10;
    }
}
