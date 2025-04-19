package src.problems;

import java.util.Arrays;

public class CoinChange {
    static Integer[] memo;
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChangeBruteForce(coins, 11));
        System.out.println(coinChangeDP(coins, 11));
    }

    // Space complexity = O(S)
    // time complexity = O(S * N) - for each amount, we need to traverse coins.
    public static int coinChangeDP(int[]coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;

        for (int i = 1; i<=amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;

                dp[i] = Math.min(dp[i], dp[i-coin] +1);
            }
        }

        return dp[amount] == (amount + 1) ? -1 : dp[amount];

    }



    // Space complexity : O(S). S, as we need to store amount in Memo table. In the worst case the maximum depth of recursion is n. Therefore we need O(n) space used by the system recursive stack.
    // Without Memo Time complexity : O(S^n). In the worst case, complexity is exponential in the number of the coins n.
    // With Memo : O(S * N) - Compute each sub-problem with N iterations, where N is number of denominations.
    public static int coinChangeBruteForce(int[] coins, int amount) {
        memo = new Integer[amount+1];
        return recursionHelper(coins, amount);
    }

    private static int recursionHelper(int[] coins, int remain) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;

        if (memo[remain] != null) {
            return memo[remain];
        }

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            int count = recursionHelper(coins, remain - coin);
            if (count == -1) continue;
            minCount = Math.min(count + 1, minCount);
        }

        memo[remain] = (minCount == Integer.MAX_VALUE ? -1 : minCount);
        return memo[remain];
    }
}
