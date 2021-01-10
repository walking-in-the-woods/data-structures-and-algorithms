package as.sort.algorithms;

public class BubbleSort {
    public static void main(String[] args) {
        //In-place algorithm (doesn't need to make copies)
        // O(n2) time complexity - quadratic
        // Stable sort algorithm
        // There is no division by sorted ond unsorted partitions

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for(int i=0; i < lastUnsortedIndex; i++) {
                if(intArray[i] > intArray[i+1]) {
                    swap(intArray, i, i+1);
                }
            }
        }
        for(int i=0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void swap(int[] array, int i, int j) {
        if(i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /* Stable and Unstable Sort Algorithms:
    If a sort is UNSTABLE, the relative ordering of duplicate items will NOT BE PRESERVED
    (the previously processed duplicate will end up coming BEFORE the next one)
    For a STABLE sort it's is vise versa.
    STABLE sort is PREFERABLE to an UNSTABLE sort.
    (It especially matters for the arrays containing objects)
     */
}
