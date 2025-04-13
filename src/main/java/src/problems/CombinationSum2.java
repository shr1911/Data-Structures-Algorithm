package src.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};

        System.out.println(combinationSum2(candidates, 8));
    }

    //In the worst case, our algorithm will exhaust all possible combinations from the input array. Again, in the worst case, let us assume that each number is unique. The number of combinations for an array of size N would be 2 N i.e. each number is included or excluded in a combination.
    //https://leetcode.com/problems/combination-sum-ii/editorial/
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentCombination = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(target, 0, currentCombination, result, candidates);

        return result;
    }

    private static void backtrack(int remain, int start, List<Integer> currentCombination, List<List<Integer>> result, int[] candidates) {
        if (remain == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = start; i <= candidates.length && remain >= candidates[i]; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currentCombination.add(candidates[i]);
            backtrack(remain - candidates[i], i + 1, currentCombination, result, candidates);
            currentCombination.remove(currentCombination.size() - 1);

        }
    }

}
