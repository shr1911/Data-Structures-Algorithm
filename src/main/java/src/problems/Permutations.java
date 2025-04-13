package src.problems;

import java.util.ArrayList;
import java.util.List;

//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(permute(nums));
    }
    //Approach 2 - https://github.com/Eric-programming/CodeSolution/blob/master/src/Backtracking/Permutations/Permutations1.java

    //Time complexity, what you should say in an interview: O(n⋅n!)
    //Finding permutations is a well-studied problem in combinatorics. Given a set of length n, the number of permutations is n! (n factorial). There are n options for the first number, n−1 for the second, and so on.
    //For each of the n! permutations, we need O(n) work to copy curr into the answer. This gives us O(n⋅n!) work.

    //Space complexity: O(n)
    //We don't count the answer as part of the space complexity. The extra space we use here is for curr and the recursion call stack. The depth of the call stack is equal to the length of curr, which is limited to n.
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    private static void backtrack(ArrayList<Integer> current, List<List<Integer>> ans, int[] nums) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int num: nums) {
            if (!current.contains(num)) {
                current.add(num);
                backtrack(current, ans, nums);
                current.remove(current.size() - 1);
            }
        }
    }
}
