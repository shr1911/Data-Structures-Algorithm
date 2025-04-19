package src.ds.sort;

import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    // Time Complexity
    //Best case (uniform input): O(n + k)
    //Average case: O(n + k log k) where k is the number of elements per bucket
    //Worst case: O(n²) (if all elements end up in one bucket)
    //Space Complexity: O(n + k)

    // Time complexity of collection.Sort() - Worst-case time complexity: O(n log n)
    //Best-case time complexity: O(n), when the list is already sorted or nearly sorted (this is due to the hybrid nature of TimSort).

    // Arrays.Sort()
    // For primitive types: O(n log n) (Dual-Pivot Quicksort)
    //For non-primitive types: O(n log n) (TimSort)
    public static void bucketSort(int[] arr) {
        if (arr.length == 0) return;

        // 1. Find min/max values to determine range
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            else if (num > max) max = num;
        }

        // 2. Calculate optimal bucket count (sqrt(n) heuristic)
        int bucketCount = (int) Math.sqrt(arr.length);
        if (bucketCount == 0) bucketCount = 1;
        int range = max - min + 1;

        // 3. Initialize buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 4. Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = (num - min) * bucketCount / range;
            bucketIndex = Math.min(bucketIndex, bucketCount - 1); // Handle edge case
            buckets.get(bucketIndex).add(num);
        }

        // 5. Sort each bucket and merge
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // Uses TimSort (hybrid of merge/insertion sort)
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {14, -15, 15, 17, 32, -4, 33, -42, 38, -36};
        System.out.println("Original: " + java.util.Arrays.toString(arr));

        bucketSort(arr);

        System.out.println("Sorted:   " + java.util.Arrays.toString(arr));
    }
}

