package org.problems;

import java.util.ArrayList;
import java.util.List;

/***
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] input = {4,1,2,1,2};
        System.out.println(singleNumber(input));
        System.out.println(singleNumberXor(input));
    }

    private static int singleNumber(int[] input) {
        List<Integer> list = new ArrayList<>();

        for (int i : input) {
            if (!list.contains(i)) {
                list.add(i);
            } else {
                list.remove(i);
            }
        }
        return list.get(0);
    }

    public static int singleNumberXor(int[] nums) {
        int xor = 0;

        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }
}
