package src.problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private static int n;
    private static int k;


    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }

    // Time complexity - https://leetcode.com/problems/combinations/editorial/
    public static List<List<Integer>> combine(int range, int combinationSize) {
        n = range;
        k = combinationSize;
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, answer);
        return answer;
    }

    private static void backtrack(ArrayList<Integer> current, int firstNum, List<List<Integer>> answer) {
        if(current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        int need = k - current.size();
        int remainNums = n - firstNum + 1;
        int available = remainNums - need;

        for (int num = firstNum; num <= firstNum + available; num++) {
            current.add(num);
            backtrack(current, num + 1, answer);
            current.remove(current.size() - 1);
        }
    }
}
