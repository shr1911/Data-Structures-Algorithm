package src.ds.sort;

import java.util.Arrays;

import static java.util.Collections.swap;



public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {7, 2, 1, 6, 8, 5, 4, 3 ,4};

        quickSort(nums, 0, nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    // Time complexity - O (nlogn) - in best average case, and O(n^2) - in worst case
    // In-place
    // fast, and efficient
    // Divide and conquer
    // Recursive
    // Not stable sort - order is not preserved
    // Randomized quick sort - Random pivot selected O(nlogn)

    // space complexity - O(logn), worst case - O(n)

    // parition based on pivot (less than pivot in left, and greater than pivot in right)
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pIndex = parition(nums, start, end);
        quickSort(nums, start, pIndex - 1);
        quickSort(nums, pIndex + 1, end);
    }

    private static int parition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pIndex = start;

        for (int i=start; i<end; i ++ ) {
            if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[pIndex];
                nums[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = nums[end];
        nums[end] = nums[pIndex];
        nums[pIndex] = temp;

        return pIndex;
    }
}
