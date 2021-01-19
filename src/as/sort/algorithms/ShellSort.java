package as.sort.algorithms;

/*
 Knuth Sequence. Gap is calculated using (3^k - 1)/2
 We set k based on the length of the array trying to make the gap as close as possible
 to the length of the array but not greater than the array length
 In the final iteration

 More simple gap calculation. Gap is array.length/2. We'll divide the gap value by 2 on each iteration

 In-place algorithm
 Time complexity depends on a gap. Worst case: O(n2), but it can perform much better than that
 Doesn't require as much shifting as insertion sort
 Unstable algorithm
*/

public class ShellSort {
    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for(int gap = intArray.length/2; gap > 0; gap /= 2) {
            for(int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                int j = i;
                while((j >= gap) && (intArray[j - gap] > newElement)) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = newElement;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
