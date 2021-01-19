package as.sort.algorithms;

/*
 Makes assumptions about the data
 Doesn't use comparisons
 Counts the number of occurrences of each value
 Only works with non-negative discrete values (can't work with floats, strings)
 Values must be within a specific range
 */

/*
 NOT an in-place algorithm
 O(n) - can achieve this because we're making assumptions about the data we're sorting
 If we want the sort to be stable, we have to do some extra steps
 */

/*
 The algorithm works its best if a range is close to the length of the sorting array
 So, it's better if the max value is close to the array length
*/

/*
 originalArray[]  {2, 5, 9, 8, 2, 8, 7, 10, 4, 3}
 inputArray[] i=0 {0, 1, 0, 0, 0, 0, 0, 0, 0, 0} - pos0 holds the number of one's we find, pos1 holds two's, etc.
 inputArray[] i=1 {0, 1, 0, 0, 1, 0, 0, 0, 0, 0}
 inputArray[] i=2 {0, 1, 0, 0, 1, 0, 0, 0, 1, 0}
 inputArray[] i=3 {0, 1, 0, 0, 1, 0, 0, 1, 1, 0}
 inputArray[] i=4 {0, 2, 0, 0, 1, 0, 0, 1, 1, 0}
 inputArray[] i=5 {0, 2, 0, 0, 1, 0, 0, 2, 1, 0}
 inputArray[] i=6 {0, 2, 0, 0, 1, 0, 1, 2, 1, 0}
 inputArray[] i=7 {0, 2, 0, 0, 1, 0, 1, 2, 1, 1}
 inputArray[] i=8 {0, 2, 0, 1, 1, 0, 1, 2, 1, 1}
 inputArray[] i=9 {0, 2, 1, 1, 1, 0, 1, 2, 1, 1}
 originalArray[]  {2, 2, 3, 4, 5, 7, 8, 8, 9, 10}
 there is 0 1s, so we do nothing
 there is 2 2s, so we write 2 2s into the array
 there is 1 3, so we write 1 3 to the array
 etc.
*/

public class CountingSort {
    public static void main(String[] args) {
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        countingSort(intArray, 1, 10);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for(int i=0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for(int i = min; i <= max; i++) {
            while(countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
