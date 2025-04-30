package src.problems;

import java.util.Arrays;
import java.util.HashMap;


public class PartitionKEqualSubsetSum {
    public static void main(String[] args) {

    }

    // Time complexity: O(N⋅2^N).
    //There will be 2^N unique combinations of the taken string, in which every combination of the given array will be linearly iterated. And if a combination occurs again then we just return the stored answer for it.
    //
    // Space complexity: O(N⋅2^N).
    //There will be 2^N unique combinations of the taken string, and each string of size N will be stored in the map. Also, the recursive stack will use at most O(N) space at any time.
    public static boolean canPartitionKSubsetsBacktrackingWithMemo(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);

        int targetSum = totalArraySum / k;

        char[] taken = new char[n];
        for(int i = 0; i < n; ++i) {
            taken[i] = '0';
        }

        // Memoize the ans using taken element's string as key.
        HashMap<String, Boolean> memo = new HashMap<>();

        return backtrackWithMemo(arr, 0, 0, 0, k, targetSum, taken, memo);
    }

    private static boolean backtrackWithMemo(int[] arr, int index, int count, int currSum, int k,
                              int targetSum, char[] taken, HashMap<String, Boolean> memo) {

        int n = arr.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        String takenStr = new String(taken);

        // If we have already computed the current combination.
        if (memo.containsKey(takenStr)) {
            return memo.get(takenStr);
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            boolean ans = backtrackWithMemo(arr, 0, count + 1, 0, k, targetSum, taken, memo);
            memo.put(takenStr, ans);
            return ans;
        }

        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (taken[j] == '0') {
                // Include this element in current subset.
                taken[j] = '1';

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrackWithMemo(arr, j + 1, count, currSum + arr[j], k, targetSum, taken, memo)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = '0';
            }
        }

        // We were not able to make a valid combination after picking each element from array,
        // hence we can't make k subsets.
        memo.put(takenStr, false);
        return false;
    }


        // Time complexity: O(k⋅2^N).
    //We are traversing the entire array for each subset (once we are done with one subset, for the next subset we are starting again with index 0). So for each subset, we are choosing the suitable elements from the array (basically iterate over nums and for each element either use it or skip it, which is O(2^N) operation).

    // Space complexity: O(N).
    //We have used an extra array of size N to mark the already used elements.
    //And the recursive tree makes at most N calls at one time, so the recursive stack also takes O(N) space.
    public static boolean canPartitionKSubsetsBacktrackingOptimization(int[] nums, int k) {
        int totalArraySum = 0;
        int n = nums.length;

        for (int i=0 ; i<n; i++) {
            totalArraySum += nums[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) return false;


        // Sort in decreasing order.
        Arrays.sort(nums);
        reverse(nums);

        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];

        return backtrackOptimized(nums, 0, 0, 0, k, targetSum, taken);
    }

    private static boolean backtrackOptimized(int[] nums, int index, int count, int currSum,
                                              int k, int targetSum, boolean[] taken) {
        int n = nums.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            return backtrackOptimized(nums, 0, count + 1, 0, k, targetSum, taken);
        }

        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrackOptimized(nums, j + 1, count, currSum + nums[j], k, targetSum, taken)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = false;
            }
        }

        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }

    static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    // Time complexity: O(N⋅N!).
    //The idea is that for each recursive call, we will iterate over N elements and make another recursive call. Assume we picked one element, then we iterate over the array and make recursive calls for the next N−1 elements and so on.
    //Therefore, in the worst-case scenario, the total number of recursive calls will be N⋅(N−1)⋅(N−2)⋅...⋅2⋅1=N! and in each recursive call we perform an O(N) time operation.

    // Space complexity: O(N).
    //We have used an extra array of size N to mark the picked elements.
    //And the maximum depth of the recursive tree is at most N, so the recursive stack also takes O(N) space.
    public static boolean canPartitionKSubsetsBacktracking(int[] nums, int k) {
        int totalArraySum = 0;
        int n = nums.length;
        
        for (int i=0 ; i<n; i++) {
            totalArraySum += nums[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) return false;
        
        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];
        
        return backtrack(nums, 0, 0, k, targetSum, taken);
    }

    private static boolean backtrack(int[] nums, int count, int currSum, int k, int targetSum, boolean[] taken) {
        int n = nums.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // Current subset sum exceeds target sum, no need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        // When current subset sum reaches target sum then one subset is made.
        // Increment count and reset current subset sum to 0.
        if (currSum == targetSum) {
            return backtrack(nums, count + 1, 0, k, targetSum, taken);
        }

        // Try not picked elements to make some combinations.
        for (int j=0; j < n; j++) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;

                // If using current jth element in this subset leads to make all valid subsets
                if (backtrack(nums, count, currSum + nums[j], k, targetSum, taken)) {
                    return true;
                }

                // Backtrack step otherwise
                taken[j] = false;
            }
        }

        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }
}
