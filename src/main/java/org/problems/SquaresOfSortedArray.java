package org.problems;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    // Time Complexity: O(N), where N is the length of A.
    // Space Complexity: O(N) if you take output into account and O(1) otherwise.
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n-1;

        for (int i = n-1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }

        return result;
    }
}
