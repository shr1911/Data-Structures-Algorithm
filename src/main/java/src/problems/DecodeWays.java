package src.problems;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(numDecodingsDP("1106"));
    }

    // Time Complexity: O(N), where N is length of the string. We're essentially doing the same work as what we were in Approach 2, except this time we're throwing away calculation results when we no longer need them.
    //
    //Space Complexity: O(1). Instead of a dp array, we're simply using two variables.
    public static int numDecodingsApproach3(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int twoBack = 1;
        int oneBack = 1;

        for (int i = 1; i < n; i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
               current = oneBack;
            }

            int twoDigit = Integer.parseInt(s.substring(i-1, i+1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBack;
            }

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }


        // Approach 2: Iterative Approach
    // Time Complexity: O(N), where N is length of the string. We iterate the length of dp array which is N+1.
    //
    //Space Complexity: O(N). The length of the DP array.
    public static int numDecodingsDP(String s) {
        // DP array to store the subproblem results
        int[] dp = new int[s.length() + 1];

        dp[0] = 1;

        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i=2; i<dp.length; i++) {
            // Check if successful single digit decode is possible.
            if (s.charAt(i-1) != '0') {
                dp[i] = dp[i - 1];
            }

            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if (twoDigit >= 10 && twoDigit <=26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];

    }

        // Time Complexity: O(N), where N is length of the string. Memoization helps in pruning the recursion tree and hence decoding for an index only once. Thus this solution is linear time complexity.
    //
    //Space Complexity: O(N). The dictionary used for memoization would take the space equal to the length of the string. There would be an entry for each index value. The recursion stack would also be equal to the length of the string.
    public static int numDecodingsRecursive(String s) {
        return recursiveWithMemo(0, s);

    }

    private static int recursiveWithMemo(int index, String str) {
        // Have we already seen this substring?
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length() - 1) {
            return 1;
        }

        int ans = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, str);
        }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }
}
