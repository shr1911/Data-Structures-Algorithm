package org.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class DisappearedNumbers {
    public static void main(String[] args) {

        int[] input = {1, 3, 6, 8};
        List<Integer> disappearedNumbersList = findDisappearedNumbers(input);
        System.out.println(disappearedNumbersList);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbersList = new ArrayList<>();

        int n = nums.length;

        for (int i=1 ; i <=n ; i++) {

        }

        return disappearedNumbersList;
    }
}
