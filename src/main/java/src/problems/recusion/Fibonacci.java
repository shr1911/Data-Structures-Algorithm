package src.problems.recusion;

import java.util.Arrays;

public class Fibonacci {

    static int[] memo = new int[51];

    public static void main(String[] args) {
        System.out.println(fibIterative(40));
        System.out.println(fibRec(40));

        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        System.out.println(fibRecWithMemorization(40));

    }

    // time complexity - O(n)
    // space complexity - O(n) + O(n)
    public static int fibRecWithMemorization (int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibRecWithMemorization(n-1) + fibRecWithMemorization(n-2);
        return memo[n];
    }


    // Recursion Tree
    // time complexity - O(2^n)
    // space complexity - O(n) - implicit stack
    public static int fibRec (int n) {
        if (n <= 1) {
            return n;
        }
        return fibRec(n-1) + fibRec(n-2);
     }

    // time complexity - O(n)
    // space complexity - O(1)
    public static int fibIterative (int n) {
        if (n <= 1) {
            return n;
        }

        int f1, f2, F;
        f1 = 0;
        f2 = 1;
        F = 0;

        for (int i=2; i<=n; i++) {
            F = f1 + f2;
            f1 = f2;
            f2 = F;
        }

        return F;
    }
}
