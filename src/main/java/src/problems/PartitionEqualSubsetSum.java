package src.problems;

public class PartitionEqualSubsetSum {
    private static Boolean[][] memo;

    public static void main(String[] args) {
        System.out.println(canPartitionDP1DArraay(new int[] {1,2,3,5}));
    }

    public static boolean canPartitionDP1DArraay(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int n = nums.length;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int i = n-1; i>=0; i--) {
            for (int j=sum; j >= 0 ; j--) {
                // We don't have option to choose nums[i], since sum is less than nums[i]
                if (j < nums[i])  continue;

                    // We have option either choose nums[i] or not to choose.
                else dp[j] |= dp[j-nums[i]];
            }
        }

        return dp[sum];

    }

        // Time complexity - O(m * n)
    // space complexity - O(m * n)

    // can optimize it to 2 row array, and even 1D array, with right to left traversal for j (space complexity - O(m))
    public static boolean canPartitionDP(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        int n = nums.length;
        sum /= 2;

        boolean[][] dp = new boolean[n + 1][sum + 1];


        // base cases
//        for (int j = 0; j <= sum; j++) {
//            dp[n][j] = false;
//        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = n-1; i>=0; i--) {
            for (int j=0; j <= sum ; j++) {
                // We don't have option to choose nums[i], since sum is less than nums[i]
                if (j < nums[i])  dp[i][j] = dp[i+1][j];

                // We have option either choose nums[i] or not to choose.
                else dp[i][j] = dp[i+1][j-nums[i]] || dp[i+1][j];
            }
        }

        return dp[0][sum];
    }


    // Time complexity = O(m*n) -> m = half of the sum of elements in array
    // Space complexity = O(m*n)
    public static boolean canPartitionBruteForceMemo(int[] nums) {
        int sum=0;

        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;

        sum = sum / 2;
        memo = new Boolean[nums.length + 1][sum + 1];
        return recursionMemo(nums, 0, sum);
    }

    private static boolean recursionMemo(int[] nums, int index, int sum) {
        if (sum == 0) return true;
        if (sum < 0 || nums.length == index) return false;

        if (memo[index][sum] != null) return memo[index][sum];

        boolean res = recursion(nums, index + 1, sum - nums[index]) || recursion(nums, index + 1, sum);
        memo[index][sum] = res;

        return res;
    }


    // Time complexity - O(2 ^ n) - TLE
    // space compelxity - O (n) - depth of recursion
    public static boolean canPartitionBruteForce(int[] nums) {
        int sum=0;

        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;

        return recursion(nums, 0, sum/2);

    }

    private static boolean recursion(int[] nums, int index, int sum) {
        if (sum == 0) return true;

        if (sum < 0 || index == nums.length) return false;

        return recursion(nums, index+1, sum - nums[index]) || recursion(nums, index+1, sum);
    }
}
