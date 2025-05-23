package src.problems;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    // Time Complexity: O(n^2).
    // Space Complexity: O(n).
    public int findNumberOfLISTopDownDP(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];

        int maxLength = 0;
        int result = 0;

        for (int i=0; i<n; i++) {
            calculateDP (i, nums, length, count);
            maxLength = Math.max(maxLength, length[i]);
        }

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }

        return result;
    }

    private void calculateDP(int i, int[] nums, int[] length, int[] count) {
        if (length[i] != 0) {
            return;
        }

        length[i] = 1;
        count[i] = 1;

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                calculateDP(j, nums, length, count);
                if (length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    count[i] = 0;
                }
                if (length[j] + 1 == length[i]) {
                    count[i] += count[j];
                }
            }
        }
    }


    // Time Complexity: O(n^2).
    // Space Complexity: O(n).
    public static int findNumberOfLISBottomUpDP(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];

        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }

                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLength = 0;
        int result = 0;

        for (int len : length) {
            maxLength = Math.max(maxLength, len);
        }

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }

        return result;
    }
}
