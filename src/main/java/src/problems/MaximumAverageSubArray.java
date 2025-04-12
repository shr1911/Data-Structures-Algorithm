package src.problems;

public class MaximumAverageSubArray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};

        System.out.println(findMaxAverage(nums, 4));

        System.out.println(findMaxAverageSlidingWindow(nums, 4));
    }

    //Time complexity : O(n). We iterate over the given nums array of length n once only.
    //Space complexity : O(1). Constant extra space is used
    private static double findMaxAverageSlidingWindow(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            res=Math.max(res,sum);
        }
        return res/k;
    }

    //Time complexity : O(n). We iterate over the nums array of length n once to fill the sum array. Then, we iterate over n−k elements of sum to determine the required result.
    //
    //Space complexity : O(n). We make use of a sum array of length n to store the cumulative sum.
    public static double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}
