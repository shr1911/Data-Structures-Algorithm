package org.ds.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 5, 3};
        bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    //Time complexity - O(n*2) worst case, ,avergae case - O(n*2), for already sorted array the complexity O(n)
    //space complexity - O(1), in-place, and stable sort
    private static void bubbleSort(int[] nums) {
        for (int k=1; k<nums.length-1; k++) {
            boolean flag = false;
//            for (int i=0; i<nums.length-2; i++) {
            for (int i=0; i<nums.length-k-1; i++) {
                if (nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    flag = true;
                }
            }
            if (flag == false) break;
        }
    }



}
