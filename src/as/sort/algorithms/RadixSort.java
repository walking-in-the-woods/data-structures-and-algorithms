package as.sort.algorithms;

/*
 Makes assumptions about the data
 Data must have same radix and width
 (The radix for decimal system is 10 (0-9), for binary system is 2 (0-1), for English alphabet is 26 (a-z))
 (The number 1235 has a width of 4, the string "hello" has a width of 5)
 Because of this, data must be integers or strings
 Sort based on each individual digit or letter position
 Start at the rightmost position
 Must use a stable sort algorithm at each stage (Critically important!)
*/

/*
 Counting Sort is often used as the sort algorithm for Radix Sort - must be stable counting sort
 O(n) - can achieve this because we're making assumption about the data we're sorting
 Even so, it often runs slower than O(nlogn) algorithms because of the overhead involved
 In-place depends on which sort algorithm you use
 Stable algorithm
*/

/*
 originalArray[] {4725, 4586, 1330, 8792, 1594, 5729}
 i=0 {1330, 8792, 1594, 4725, 4586, 5729} - sorted by the 1's position: 0, 2, 4, 5, 6, 9
 i=1 {4725, 5729, 1330, 4586, 8792, 1594} - sorted by the 10's position: 2, 2, 3, 8, 9, 9
 i=2 {1330, 4586, 1594, 4725, 5729, 8792} - sorted by the 100's position: 3, 5, 5, 7, 7, 7
 i=3 {1330, 1594, 4586, 4725, 5729, 8792} - sorted by the 1000's position: 1, 1, 4, 4, 5, 8
*/

/*
 Stable Counting Sort:
 originalArray[] {1330, 8792, 1594, 4725, 4586, 5729}
 i=0 {0, 0, 2, 1, 0, 0, 0, 0, 1, 2} - counting for 1's position
 Make temp array with a length of original array (6)
 i=0 {0, 0, 2, 3, 3, 3, 3, 3, 4, 6} - adjusted count array where each element, instead og containing
 the exact count of how many values have a specific digit, it contains of how many values have that digit or less
 We don't have any values with 0, we don't have any values with 1 or less,
 we have 2 values with 2 or less, 3 values with 3 or less, 3 values with 4 or less,
 3 values with 5 or less, up to the value of 8, where we have 4 values of 8 or less,
 and finally, we have 6 values with 9 or less.
 */

/*
 And now we're going to use that to write back to our input array
 We initialise our temp array (n is the number of sorted elements) and then we traverse the array backwards
*/

/*
 int[] tmp = new int[n];
 for(int k = n - 1; k > 0; k--) {
     tmp[--countArray[getDigit(position, input[k], radix)]] = input[k];
 }
*/

/*
 n = length of the input array = 6, k starts at 5 and goes to 0
 When k = 5:
 countArray[getDigit(...)] = countArray[2] for 5729 (input[k] = 2)
 We are using the prefix operator, so we subtract one from countArray[2] = 1, then assign input[k] (5729) to tmp[1]
 tmp[] {0, 5729, 0, 0, 0, 0}
 countArray[] {0, 0, 1, 3, 3, 3, 3, 3, 4, 6}
 Temp array now has 5729, countArray[2] has been decremented by 1,
 since we've written out one value with 2 in the 10's position
*/
/*
 When k = 4:
 countArray[getDigit(...)] = countArray[8] for 4586 (input[k] = 4)
 subtract 1 from countArray[8] = 3, assign input[k] (4586) to tmp[3]
 tmp[] {0, 5729, 0, 4586, 0, 0}
 countArray[] {0, 0, 1, 3, 3, 3, 3, 3, 3, 6}
 Temp array now has 4586, countArray[8] has been decremented by 1,
 since we've written out one value with 8 in the 10's position
*/
/*
 When k = 3:
 countArray[getDigit(...)] = countArray[2] for 4725 (input[k] = 1)
 subtract 1 from countArray[2] = 3, assign input[k] (4725) to tmp[0]
 tmp[] {4725, 5729, 0, 4586, 0, 0}
 countArray[] {0, 0, 0, 3, 3, 3, 3, 3, 3, 6}
 Temp array now has 5725, countArray[2] has been decremented by 1,
 since we've written out one value with 2 in the 10's position
*/
/*
 When k = 2:
 countArray[getDigit(...)] = countArray[9] for 1594 (input[k] = 6)
 subtract 1 from countArray[9] = 5, assign input[k] (1594) to tmp[5]
 tmp[] {4725, 5729, 0, 4586, 0, 1594}
 countArray[] {0, 0, 0, 3, 3, 3, 3, 3, 3, 5}
 Temp array now has 1594, countArray[9] has been decremented by 1,
 since we've written out one value with 9 in the 10's position
 When k = 1:
*/
/*
 countArray[getDigit(...)] = countArray[9] for 8792 (input[k] = 5)
 subtract 1 from countArray[9] = 4, assign input[k] (8792) to tmp[4]
 tmp[] {4725, 5729, 0, 4586, 8792, 1594}
 countArray[] {0, 0, 0, 3, 3, 3, 3, 3, 3, 4}
 Temp array now has 8792, countArray[9] has been decremented by 1,
 since we've written out one value with 9 in the 10's position
*/
/*
 When k = 0:
 countArray[getDigit(...)] = countArray[3] for 1330 (input[k] = 3)
 subtract 1 from countArray[3] = 2, assign input[k] (1330) to tmp[2]
 tmp[] {4725, 5729, 1330, 4586, 8792, 1594}
 countArray[] {0, 0, 0, 2, 3, 3, 3, 3, 3, 4}
 Temp array now has 1330, countArray[3] has been decremented by 1,
 since we've written out one value with 3 in the 10's position
 {xx2x, xx2x, xx3x, xx8x, xx9x, xx9x}, all the duplicates are preserved!
 Now we would copy the temporary array into the input array
 This is the stable counting sort
*/

public class RadixSort {
    public static void main(String[] args) {
        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(radixArray, 10, 4);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(int[] input, int radix, int width) {
        // loop through the digit positions
        for(int i=0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for(int value : input) {
            countArray[getDigit(position, value, radix)]++;
        }

        // Adjust the count array
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
