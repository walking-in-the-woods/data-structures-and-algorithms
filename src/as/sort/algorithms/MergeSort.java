package as.sort.algorithms;

/*
 Divide and conquer algorithm
 Recursive algorithm
 Two phases: Splitting and Merging
 Splitting phase leads to faster sorting during the Merging phase
 Splitting is logical. We don't create new arrays
*/

/*
 SPLITTING PHASE:
 Start with an unsorted array. Divide the array into two (left/right) recursively
 until all the arrays have only one element each - these arrays are sorted
 MERGING PHASE:
 Merge every left/right pair of sibling arrays into a sorted array
 Repeat the merging recursively until you have a single sorted array
 Merging process:
 1. Create a temporary array large enough to contain both left and right siblings
 2. Set i and j to the fist indexes of the left and the right siblings
 3. Compare left[i] to right[j]. Copy the smallest to the temp array and increment i or j by 1
 4. Copy the temp array back to the original input array
*/

/*
 NOT an in-place algorithm. Uses temporary arrays.
 O(nlogn) - base 2. We're repeatedly dividing the array in half during the splitting phase
 Stable algorithm
*/

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // {20, 35, -15, 7, 55, 1, -22}
    public static void mergeSort(int[] input, int start, int end) {
        if(end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // {20, 35, -15, 7, 55, 1, -22}
    public static void merge(int[] input, int start, int mid, int end) {
        // Compare the last element in the left and the first element in the right
        // if the condition is true the deal is done because both the arrays are already sorted
        if(input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while(i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        /*
        (32, 34), (33, 36)
        (32, 33, 34, 36)
        if we completely copied values to the left array
        the right array is already sorted an is grater than the left one
        */
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
