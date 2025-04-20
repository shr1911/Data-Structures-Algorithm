package src.problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePathsDP(3, 7));
        System.out.println(uniquePathsRecursion(3, 7));
    }

    // Time complexity: O(N×M).
    // Space complexity: O(N×M).
    public static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }

        for ( int row = 1; row < m ; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] =  dp[row - 1][col] + dp[row][col- 1 ];
            }
        }

        return dp[m - 1] [n - 1];
    }

    // Time complexity - O(2^ (m+n)) - very bad time complexity, as exponential
    // Exponential growth due to overlapping subproblems

    // space complexity - Since the recursion can go as deep as m + n, the space complexity (call stack) is: O(m + n)
    public static int uniquePathsRecursion(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePathsRecursion(m - 1, n) + uniquePathsRecursion(m, n - 1);
    }
}
