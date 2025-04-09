package org.ds.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 5, 3};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // little more efficient than bubble and selection sort, because number of comparison in practical case here is much lesser compare to other two alog
    //Time complexity - O(n*2) worst case, O(n), best case,
    //space complexity - O(1), in-space, stable
    private static void insertionSort(int[] nums) {
        for (int i = 1; i<nums.length; i++) {
            int value = nums[i];
            int hole = i;

            while (hole > 0 && nums[hole - 1] > value) {
                nums[hole] = nums[hole-1];
                hole--;
            }

            nums[hole] = value;
        }
    }


}
