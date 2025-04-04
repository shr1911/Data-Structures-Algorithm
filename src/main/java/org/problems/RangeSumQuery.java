package org.problems;


/**
 * Given an integer array nums, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices
 * left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQuery {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        //int[] nums = {1, 2, 3, 4, 5, 6};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }

    //Time complexity: O(1) time per query, O(n) time pre-computation.
    //Since the cumulative sum is cached, each sumRange query can be calculated in O(1) time.
    //
    //Space complexity: O(n).
    static class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }
}