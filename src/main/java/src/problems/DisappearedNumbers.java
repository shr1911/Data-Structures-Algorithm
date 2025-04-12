package src.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class DisappearedNumbers {
    public static void main(String[] args) {

        int[] input = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbersList = findDisappearedNumbers(input);
        System.out.println(disappearedNumbersList);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        List<Integer> result = new LinkedList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }
}
