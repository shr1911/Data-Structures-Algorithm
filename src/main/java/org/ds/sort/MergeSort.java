package org.ds.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {2, 4, 1, 6, 8, 5, 3, 7};

        mergeSort(input, 0, input.length-1);

        System.out.println(Arrays.toString(input));
    }

    // stable sort algo
    // Not in-place algo
    // Recursive
    // space complexity - O (n), if space is cleared  - theata(nlogn), if garbage not collected
    //time complexity - O(nlogn) - theta(nlogn)

    // Time Complexity: O(n log n)
    // Space Complexity: O(n) (due to the temporary merge array)
    // Stable, reliable sorting algorithm with guaranteed O(n log n) performance
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort left half
            mergeSort(arr, left, mid);

            // Sort right half
            mergeSort(arr, mid + 1, right);

            // Merge sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

}
