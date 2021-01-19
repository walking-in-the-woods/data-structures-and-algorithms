package as.sort.algorithms;

/*
 1! = 1 * 0! = 1
 2! = 2 * 1 = 2 * 1!
 3! = 3 * 2 * 1 = 3 * 2!
 4! = 4 * 3 * 2 * 1 = 4 * 3!
*/

// n! = n * (n-1)!

/*
 Call stack:
 recursiveFactorial(3) - is waiting for (2) solution
 + recursiveFactorial(2) - is waiting for (1) solution
 + + recursiveFactorial(1)
 we can get a StackOverflowError
*/

// Iterative implementations are usually run faster

public class Recursion {
    public static void main(String[] args) {

        System.out.println(iterativeFactorial(3));
        System.out.println(recursiveFactorial(3));

    }

    public static int iterativeFactorial(int num) {
        if(num == 0) {
            return 1;
        }
        int factorial = 1;
        for(int i=1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int recursiveFactorial(int num) {
        // base case (the breaking condition)
        if(num == 0) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }
}
