package src.ds.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 5, 3};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //Time complexity - O(n*2)
    //space complexity - O(1), in-place, and stable sort
    private static void selectionSort(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            int iMin = i;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] > nums[i]) {
                    iMin = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[iMin];
            nums[iMin] = temp;
        }
    }
}
