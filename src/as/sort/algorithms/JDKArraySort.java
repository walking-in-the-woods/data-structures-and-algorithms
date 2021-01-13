package as.sort.algorithms;

import java.util.Arrays;

public class JDKArraySort {
    public static void main(String[] args) {
        int[] intArray = {20, 30, -15, 7, 55, 1, -22};

        Arrays.sort(intArray);
        Arrays.parallelSort(intArray);

        for(int i=0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
