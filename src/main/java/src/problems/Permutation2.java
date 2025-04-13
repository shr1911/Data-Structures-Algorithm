package src.problems;

import java.util.*;

public class Permutation2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(permuteUnique(nums));
    }

    // Approach 2 - https://github.com/Eric-programming/CodeSolution/blob/master/src/Backtracking/Permutations/Permutations1.java
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num)) counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected static void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results
    ) {
        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }


    //Time: O(n × n!) in the worst case (but less if many duplicates exist)
    //
    //Space: O(n) for recursion stack + O(n!) for result list
    public static List<List<Integer>> permuteUniqueConditionBased(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // Sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrackConditionBased(nums, new ArrayList<>(), used, res);
        return res;
    }


    private static void backtrackConditionBased(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;

            // Skip duplicates: only use the first occurrence unless the previous duplicate has been used
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            curr.add(nums[i]);
            backtrackConditionBased(nums, curr, used, res);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }


}
