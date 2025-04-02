package org.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
  */

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 4};

        boolean hasDuplicate = containsDuplicate(input);
        System.out.println(hasDuplicate);
    }

    // Native linear search - O(n^2)
    // Sorting approach will have time complexity O(n * logn)
    // Time Complexity - O(n)
    // Space Complexity - O(n)
    private static boolean containsDuplicate(int[] input) {
        Set<Integer> set = new HashSet<>();

        for (int item: input){
            if (set.contains(item)){
                return true;
            }
            set.add(item);
        }
        return false;
    }
}
