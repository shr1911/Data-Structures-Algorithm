package src.problems;

import java.lang.reflect.Array;

public class JumpGame {
    static Index[] memo;

    public static void main(String[] args) {
        System.out.println(canJumpDPTopDown(new int[] {2,3,1,1,4}));
    }

    // Time complexity : O(n).
    // We are doing a single pass through the nums array, hence n steps, where n is the length of array nums.
    //
    // Space complexity : O(1).
    // We are not using any extra memory.
    public static boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        return lastPos == 0;
    }

    // Time complexity : O(n^2).
    // For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most n, where n is the length of array nums.
    //
    // Space complexity : O(n).
    // This comes from the usage of the memo table.
    public static boolean canJumpDPBottomUp(int[] nums) {
        Index[] memo = new Index[nums.length];

        for (int i=0; i<memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }

        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length-1);

            for (int j = i+1; j<=furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
         }

        return memo[0] == Index.GOOD;
    }

        // Time complexity : O(n^2).
    //For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most n, where n is the length of array nums.

    // Space complexity : O(2n)=O(n).
    // First n originates from recursion. Second n comes from the usage of the memo table.
    public static boolean canJumpDPTopDown(int[] nums) {
        memo = new Index[nums.length];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }

        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPositionDPTopDown(0, nums);
    }

    private static boolean canJumpFromPositionDPTopDown(int position, int[] nums) {
        if(memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionDPTopDown(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }
}

enum Index {
    GOOD,
    BAD,
    UNKNOWN,
}
