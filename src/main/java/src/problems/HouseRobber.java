package src.problems;

import java.util.Arrays;

public class HouseRobber {
    private static int[] memo;

    public static void main(String[] args) {
        System.out.println(robDPOptimized(new int[] {1, 2, 3, 1}));
    }

    // Time Complexity: O(N) since we have a loop from N−2⋯0 and we use the precalculated values of our dynamic programming table to calculate the current value in the table which is a constant time operation.
    //Space Complexity: O(1) since we are not using a table to store our values. Simply using two variables will suffice for our calculations.
    public static int robDPOptimized(int[] nums) {
            int N = nums.length;

            // Special handling for empty array case.
            if (N == 0) {
                return 0;
            }

            int robNext, robNextPlusOne;

            // Base case initializations.
            robNextPlusOne = 0;
            robNext = nums[N - 1];

            // DP table calculations. Note: we are not using any
            // table here for storing values. Just using two
            // variables will suffice.
            for (int i = N - 2; i >= 0; --i) {
                // Same as the recursive solution.
                int current = Math.max(robNext, robNextPlusOne + nums[i]);

                // Update the variables
                robNextPlusOne = robNext;
                robNext = current;
            }

            return robNext;
    }

    // Time Complexity: O(N) since we have a loop from N−2⋯0 and we simply use the pre-calculated values of our dynamic programming table for calculating the current value in the table which is a constant time operation.
    // Space Complexity: O(N) which is used by the table. So what is the real advantage of this solution over the previous solution? In this case, we don't have a recursion stack. When the number of houses is large, a recursion stack can become a serious limitation, because the recursion stack size will be huge and the compiler will eventually run into stack-overflow problems (no pun intended!).
    public int robDP(int[] nums) {
        int N = nums.length;

        // Special handling for empty array case.
        if (N == 0) {
            return 0;
        }

        int[] maxRobbedAmount = new int[nums.length + 1];

        // Base case initializations.
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N - 1] = nums[N - 1];

        // DP table calculations.
        for (int i = N - 2; i >= 0; --i) {
            // Same as the recursive solution.
            maxRobbedAmount[i] = Math.max(
                    maxRobbedAmount[i + 1],
                    maxRobbedAmount[i + 2] + nums[i]
            );
        }

        return maxRobbedAmount[0];
    }

    //Time Complexity: O(N) since we process at most N recursive calls, thanks to caching, and during each of these calls, we make an O(1) computation which is simply making two other recursive calls, finding their maximum, and populating the cache based on that.
    //
    //Space Complexity: O(N) which is occupied by the cache and also by the recursion stack.
    public static int robRecursion(int[] nums) {
        memo = new int[100];

        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(memo, -1);

        return robFromRecursion(0, nums);
    }

    private static int robFromRecursion(int i, int[] nums) {
        // No more houses left to examine.
        if (i >= nums.length) {
            return 0;
        }

        // Return cached value.
        if (memo[i] > -1) {
            return memo[i];
        }

        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(
                robFromRecursion(i + 1, nums),
                robFromRecursion(i + 2, nums) + nums[i]
        );

        // Cache for future use.
        memo[i] = ans;
        return ans;
    }
}
