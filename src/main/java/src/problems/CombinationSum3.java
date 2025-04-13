package src.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    static int k;
    static int n;

    public static void main(String[] args) {
        k = 3;
        n = 9;
        System.out.println(combinationSum3(k, n));
    }

    //Time complexity: O(K×C(9,K))
    //The algorithm involves generating all possible combinations of K distinct numbers chosen from the range [1, 9].
    //The number of ways to choose K distinct numbers from the set 1,2,...,9 is represented by the permutation C(9,K), which is the number of ways to arrange K numbers from 9. The formula for C(9,K) is:
    //For each valid combination, it takes O(K) time to construct the combination, as copying the current combination into the result requires O(K) operations.
    //Therefore, the overall time complexity becomes: O(K×C(9,K))


    //Space Complexity: O(K)
    //During the backtracking, we used a list to keep the current combination, which holds up to K elements, i.e. O(K).
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentCombination = new ArrayList<Integer>();

        backtrack(n, 1, currentCombination, result);
        return result;
    }

    private static void backtrack(int remain, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (currentCombination.size() == k && remain == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        } else if (currentCombination.size() > k || remain < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            currentCombination.add(i);
            backtrack(remain - i,  i+1, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
