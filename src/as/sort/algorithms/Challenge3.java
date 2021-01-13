package as.sort.algorithms;

// Radix sort of strings

public class Challenge3 {
    public static void main(String[] args) {
        String[] stringArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        radixSort(stringArray, 26, 5);

        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
    }

    public static void radixSort(String[] input, int radix, int width) {
        // loop through the digit positions
        for(int i = width - 1; i >= 0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(String[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for(String value : input) {
            countArray[getIndex(position, value)]++;
        }

        // Adjust the count array
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(position, input[tempIndex])]] = input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    public static int getIndex(int position, String value) {
        // - 'a' is translation the numeric value for the character into an index in the counting array
        // Letters in the ASCII system have values 97, 98, 99, etc.
        // we can translate a character to its position the counting array just by subtracting 'a'
        // from the value of that character
        return value.charAt(position) - 'a';
    }
}
