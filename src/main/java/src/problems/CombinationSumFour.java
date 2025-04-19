package src.problems;

import java.util.HashMap;

public class CombinationSumFour {
    private static HashMap<Integer, Integer> memo;

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(combinationSum4(nums, 4));
    }

    // Let T be the target value, and N be the number of elements in the input array.
    //Time Complexity: O(T⋅N)
    //
    //Thanks to the memoization technique, for each invocation of combs(remain), it would be evaluated only once, for each unique input value.
    //In the worst case, we could have T different input values.
    //For each invocation of combs(remain), in the worst case it takes O(N) time for the non-recursive part.
    //To sum up, the overall time complexity of the algorithm is T⋅O(N)=O(T⋅N)


    // Space Complexity: O(T)
    //
    //Due to the recursive function, the algorithm will incur additional memory consumption in the function call stack.
    //In the worst case, the recursive function can pile up to T times.
    //As a result, we would need O(T) space for the recursive function.
    //In addition, since we applied the memoization technique where we keep the intermediate results in the cache, we would need addtionally O(T) space.
    //To sum up, the overall space complexity of the algorithm is O(T)+O(T)=O(T)
    public static int combinationSum4(int[] nums, int target) {
        // minor optimization
        // Arrays.sort(nums);
        memo = new HashMap<>();
        return combs(nums, target);
    }

    private static int combs(int[] nums, int remain) {
        if (remain == 0) return 1;

        if (memo.containsKey(remain)) return memo.get(remain);

        int result = 0;
        for (int num: nums) {
            if (remain - num > 0) {
                result += combs(nums, remain - num);
            }
        }

        memo.put(remain, result);
        return result;
    }
}
