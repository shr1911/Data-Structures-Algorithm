package src.problems;

import java.util.Arrays;

public class TargetSum {
    static int totalWays = 0;
    // Sum of all elements in the array
    static int totalSum;

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(findTargetSumWaysDP(nums, 0));
    }

    // Time complexity: O(n⋅totalSum)
    //The time complexity is determined by the nested loops in the function. The outer loop runs n times (once for each element in nums), and the inner loop runs 2⋅totalSum+1 times (once for each possible sum from −totalSum to totalSum).
    //Therefore, the overall time complexity is O(n⋅totalSum).

    //Space complexity: O(n⋅totalSum)
    //The space complexity is determined by the size of the DP table dp, which is a 2D array of size n×(2⋅totalSum+1). Each entry in the DP table requires constant space, so the total space complexity is O(n⋅totalSum).
    public static int findTargetSumWaysDP(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * totalSum + 1];

        // Initialize the first row of the DP table
        dp[0][nums[0] + totalSum] = 1;
        dp[0][-nums[0] + totalSum] += 1;

        // Fill the DP table
        for (int index = 1; index < nums.length; index++) {
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[index - 1][sum + totalSum] > 0) {
                    dp[index][sum + nums[index] + totalSum] += dp[index - 1][sum + totalSum];
                    dp[index][sum - nums[index] + totalSum] += dp[index - 1][sum + totalSum];
                }
            }
        }

        // Return the result if the target is within the valid range
        return Math.abs(target) > totalSum
                ? 0
                : dp[nums.length - 1][target + totalSum];
    }

    //Time complexity: O(n⋅totalSum)
    //In the worst case, the function calculateWays is called for each index in the array and each possible sum within the range [−totalSum,totalSum]. Since the sum can range from −totalSum to totalSum, there are 2⋅totalSum+1 possible sums.
    //Therefore, the total number of unique states (index, sum) is n×(2⋅totalSum+1). Each state is computed once and stored in the memoization table, leading to a time complexity of O(n⋅totalSum).

    //Space complexity: O(n⋅totalSum)
    //The space complexity is determined by the memoization table, which has dimensions n×(2⋅totalSum+1). Additionally, the recursion stack can go as deep as n, but this is typically dominated by the space used by the memoization table. Therefore, the space complexity is O(n⋅totalSum).
    //The space complexity also includes the space used by the built-in functions, such as computing the sum and filling the rows. However, these operations are linear in terms of the input size and do not significantly affect the overall space complexity, which is dominated by the memoization table.
    public static int findTargetSumWaysMemorization(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculateWaysMemorization(nums, 0, 0, target, memo);
    }

    private static int calculateWaysMemorization(int[] nums, int currentIndex, int currentSum, int target, int[][] memo) {
        if (currentIndex == nums.length) {
            // Check if the current sum matches the target
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            // Check if the result is already computed
            if (
                    memo[currentIndex][currentSum + totalSum] != Integer.MIN_VALUE
            ) {
                return memo[currentIndex][currentSum + totalSum];
            }
            // Calculate ways by adding the current number
            int add = calculateWaysMemorization(
                    nums,
                    currentIndex + 1,
                    currentSum + nums[currentIndex],
                    target,
                    memo
            );

            // Calculate ways by subtracting the current number
            int subtract = calculateWaysMemorization(
                    nums,
                    currentIndex + 1,
                    currentSum - nums[currentIndex],
                    target,
                    memo
            );

            // Store the result in memoization table
            memo[currentIndex][currentSum + totalSum] = add + subtract;

            return memo[currentIndex][currentSum + totalSum];
        }
    }

    // Time complexity: O(2^n)
    // The function calculateWays is a recursive function that branches out into two recursive calls at each step. This is because each element in the array can either be added or subtracted, leading to 2 choices for each of the n elements.

    //Space complexity: O(n)
    //The space complexity is determined by the depth of the recursion stack. In the worst case, the recursion stack can go as deep as n levels (one level for each element in the array). Therefore, the space complexity is O(n).
    public static int findTargetSumWaysBruteForce(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;
    }

    private static void calculateWays(int[] nums, int currentIndex, int currentSum, int target) {
        if (currentIndex == nums.length) {
            // Check if the current sum matches the target
            if (currentSum == target) {
                totalWays++;
            }
        } else {
            // Include the current number with a positive sign
            calculateWays(nums, currentIndex + 1, currentSum + nums[currentIndex], target);

            // Include the current number with a negative sign
            calculateWays(nums, currentIndex + 1, currentSum - nums[currentIndex], target);
        }
    }
}
