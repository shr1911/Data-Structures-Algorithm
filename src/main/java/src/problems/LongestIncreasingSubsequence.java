package src.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7};
        System.out.println(lengthOfLIS(nums));
    }

    // Time complexity: O(N⋅log(N))
    // Binary search uses log(N) time as opposed to the O(N) time of a linear scan, which improves our time complexity from O(N^2) to O(N⋅log(N)).
    //
    //Space complexity: O(N)
    //When the input is strictly increasing, the sub array will be the same size as the input.
    public static int lengthOfLISBinarySearch(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }

        return sub.size();
    }

    private static int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Time complexity: O(N^2)
    //
    //This algorithm will have a runtime of  O(N^2) only in the worst case. Consider an input where the first half is [1, 2, 3, 4, ..., 99998, 99999], then the second half is [99998, 99998, 99998, ..., 99998, 99998]. We would need to iterate (N/2)^2 times for the second half because there are N/2 elements equal to 99998, and a linear scan for each one takes N/2 iterations. This gives a time complexity of O(N^2).
    //Despite having the same time complexity as the previous approach, in the best and average cases, it is much more efficient.

    //Space complexity: O(N)
    //When the input is strictly increasing, the sub array will be the same size as the input.
    public static int lengthOfLISApproach2(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i=1 ; i< nums.length ; i++) {
            int num = nums[i];

            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j=0;
                while (num > sub.get(j)) {
                    j++;
                }
                sub.set(j, num);
            }
        }

        return sub.size();
    }

    // Time complexity: O(N^2)
    //Space complexity: O(N)
    //The only extra space we use relative to input size is the dp array, which is the same length as nums.
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i=1; i<nums.length; i++) {
            for (int j=0 ; j<i ; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int num: dp) {
            longest = Math.max(longest, num);
        }

        return longest;
    }
}
