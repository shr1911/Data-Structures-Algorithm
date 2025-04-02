package org.problems;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] input = {0, 1, 2, 3, 5, 6};
        int missingNumber = findMissingNumber(input);
        System.out.println(missingNumber);
    }

    // Sort and check if it's equal to expected number approach - O(n*longn)
    // insert in set, and later check what's missing in range - O(n)
    // Bit manipulation approach - ?
    // Time Complexity - O(n)
    // Space Complexity - O(n)
    private static int findMissingNumber(int[] input) {
        int sum = input.length * (input.length + 1) / 2;
        int inputSum = 0;

        for (int item : input){
           inputSum = inputSum + item;
        }
        return sum - inputSum;
    }
}
