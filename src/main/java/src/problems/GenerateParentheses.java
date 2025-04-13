package src.problems;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtracking(result, new StringBuilder(), 0, 0, n);

        return result;

    }

    // Time complexity - O(2ⁿ * n)

    // Space complexity: O(n)
    // The space complexity of a recursive call depends on the maximum depth of the recursive call stack, which is 2n. As each recursive call either adds a left parenthesis or a right parenthesis, and the total number of parentheses is 2n. Therefore, at most O(n) levels of recursion will be created, and each level consumes a constant amount of space.
    private static void backtracking(List<String> result, StringBuilder currentString, int leftCount, int rightCount, int n) {
        if (currentString.length() == 2*n) {
            result.add(currentString.toString());
            return;
        }

        if (leftCount < n) {
            currentString.append("(");
            backtracking(result, currentString, leftCount + 1, rightCount, n);
            currentString.deleteCharAt(currentString.length() - 1);
        }

        if (leftCount > rightCount) {
            currentString.append(")");
            backtracking(result, currentString, leftCount, rightCount + 1, n);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }

    private static boolean isValid(String pString) {
        int leftCount = 0;
        for (char p : pString.toCharArray()) {
            if (p == '(') {
                leftCount++;
            } else {
                leftCount--;
            }

            if (leftCount < 0) {
                return false;
            }
        }
        return leftCount == 0;
    }

    //Time complexity: O((2 ^2n )* n)
    //We are generating all possible strings of length 2n. At each character, we have two choices: choosing ( or ), which means there are a total of  O((2 ^2n )* n) unique strings.
    //For each string of length 2n, we need to iterate through each character to verify it is a valid combination of parentheses, which takes an average of O(n) time.

    // Space complexity: O((2 ^2n )* n)
    // Before we dequeue the first string of length 2n from queue, it has stored 2 ^2(n-1) strings of length n−1, which takes O((2 ^2n )* n)
    public List<String> generateParenthesisBruteForce(int n) {
        List<String> answer = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(Arrays.asList(""));

        while (!queue.isEmpty()) {
            String curString = queue.poll();

            // If the length of curString is 2 * n, add it to `answer` if
            // it is valid.
            if (curString.length() == 2 * n) {
                if (isValid(curString)) {
                    answer.add(curString);
                }
                continue;
            }
            queue.offer(curString + ")");
            queue.offer(curString + "(");
        }

        return answer;
    }
}
