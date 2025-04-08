package org.problems;

public class MajorityElements {

    //Time complexity : O(n)
    //
    //Boyer-Moore performs constant work exactly n times, so the algorithm
    //runs in linear time.
    //
    //Space complexity : O(1)
    //
    //Boyer-Moore allocates only constant additional memory.
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
