package src.problems;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindromeDP("babad"));

    }

    public static String longestPalindromeDP(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[] {0, 0};

        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }

        for (int i=0; i<n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i+1;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i=0 ; i < n-diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j+1);
    }

    // Time complexity - O (n^3) - Note that this time complexity is in the worst case and has a significant constant divisor that is dropped by big O. Due to the optimizations of checking the longer length substrings first and exiting the palindrome check early if we determine that a substring cannot be a palindrome, the practical runtime of this algorithm is not too bad.

    // Space complexity: O(1)
    //We don't count the answer as part of the space complexity. Thus, all we use are a few integer variables.
    public static String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (checkPlaindrome(start, start + length, s)) {
                    return s.substring(start, start + length);
                }
            }
        }

        return "";
    }

    private static boolean checkPlaindrome(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
