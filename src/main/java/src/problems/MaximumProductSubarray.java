package src.problems;

public class MaximumProductSubarray {
    public static void main(String[] args) {

    }

    // O(N) where N is the size of nums. The algorithm achieves linear runtime since we are going through nums only once.
    //
    //Space complexity : O(1) since no additional space is consumed rather than variables which keep track of the maximum product so far, the minimum product so far, current variable, temp variable, and placeholder variable for the result.
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(
                    curr,
                    Math.max(max_so_far * curr, min_so_far * curr)
            );
            min_so_far = Math.min(
                    curr,
                    Math.min(max_so_far * curr, min_so_far * curr)
            );

            // Update max_so_far after min_so_far to avoid overwriting it
            max_so_far = temp_max;
            // Update the result with the maximum product found so far
            result = Math.max(max_so_far, result);
        }

        return result;
    }

    // Time complexity : O(N^2) where N is the size of nums. Since we are checking every possible contiguous subarray following every element in nums we have quadratic runtime.
    //
    //Space complexity : O(1) since we are not consuming additional space other than two variables: result to hold the final result and accu to accumulate product of preceding contiguous subarrays.
    public static int maxProductIterative(int[] nums) {
        if (nums.length == 0) return 0;

        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int accu = 1;
            for (int j = i; j < nums.length; j++) {
                accu *= nums[j];
                result = Math.max(result, accu);
            }
        }

        return result;
    }
}
