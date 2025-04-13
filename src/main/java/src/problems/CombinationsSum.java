package src.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationsSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }

    public static List<List<Integer>> combinationSum (int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> currentCombination = new ArrayList<Integer>();
        backtrack(target, currentCombination, 0, candidates, results);

        return results;
    }

    // The maximal depth of the tree, would be T/M.

    // Time complexity - The time complexity can be approximated as O(N^(T/M) + N), where:
    // N is the number of candidates (n).
    // T is the target sum (t).
    // M is the minimum value among the candidates.
    // The + N accounts for the initial iteration over candidates.

    // Space complexity = The space complexity is O(T/M) due to the recursion stack depth in the worst case.
    private static void backtrack(int remain, List<Integer> currentCombination, int start, int[] candidates, List<List<Integer>> results) {
        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<>(currentCombination));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i=start ; i < candidates.length; i++) {
            // add the number into the combination
            currentCombination.add(candidates[i]);
            backtrack(remain - candidates[i], currentCombination, i, candidates, results);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }


}
