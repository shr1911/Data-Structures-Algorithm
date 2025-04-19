package src.problems;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println(rob(nums));
    }

    // Time complexity : O(N) where N is the size of nums. We are accumulating results as we are scanning nums.
    //Space complexity : O(1) since we are not consuming additional space other than variables for two previous results and a temporary variable to hold one of the previous results.
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int max1 = rob_simple(nums, 0, nums.length-2);
        int max2 = rob_simple(nums, 1, nums.length-1);

        return Math.max(max1, max2);
    }

    public static int rob_simple(int[] nums, int start, int end) {
        int t1 = 0, t2 = 0;

        for (int i = start; i <= end; i++){
            int temp = t1;
            int current = nums[i];
            t1 = Math.max((current + t2), t1);
            t2 = temp;
        }

        return t1;
    }
}
