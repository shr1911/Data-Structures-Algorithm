package org.problems;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    // For non-memo based
    // Time - O(2^n)
    // Space - O(n) - depth of tree can go upto max height - dure to recursion function call
    // Time complexity : O(n). Size of recursion tree can go up to n.
    // Space complexity : O(n). The depth of recursion tree can go up to n.
    public static int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    //Time complexity : O(n). Single loop up to n.
    //Space complexity : O(n). dp array of size n is used.
    public int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Time complexity : O(n). Single loop upto n is required to calculate nth fibonacci number.
    //Space complexity : O(1). Constant space is used.
    public int climbStairsFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
