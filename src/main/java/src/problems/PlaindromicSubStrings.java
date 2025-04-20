package src.problems;

public class PlaindromicSubStrings {
    public static void main(String[] args) {

    }

    // Approach 3: Expand Around Possible Centers
    public static int countSubstrings(String s) {
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // odd-length palindromes, single character center
            ans += countPalindromeAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            ans += countPalindromeAroundCenter(s, i, i+1);
        }

        return ans;
    }

    // Time Complexity: O(N^2) for input string of length N. The total time taken in this approach is dictated by two variables:
    // - The number of possible palindromic centers we process.
    // - How much time we spend processing each center.

    // Space Complexity: O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.
    private static int countPalindromeAroundCenter(String ss, int low, int high) {
        int ans = 0;

        while (low >= 0 && high < ss.length()) {
            if (ss.charAt(low) != ss.charAt(high)) break; // the first and last characters don't match!

            // expand around the center
            low--;
            high++;

            ans++;
        }

        return ans;
    }


    // Time Complexity: O(N^2) for input string of length N.
    // Space Complexity: O(N^2) for an input string of length N.
    public static int countSubstringsDP(String s) {
        int n = s.length();
        int ans = 0;

        if (n == 0) return 0;

        boolean[][] dp = new boolean[n][n];


        // Base case: single letter substrings
        for (int i = 0; i < n ; i++, ans++) {
            dp[i][i] = true;
        }

        // Base case: double letter substrings
        for (int i = 0 ; i < n-1; i++) {
            dp[i][i+1] = (s.charAt(i) == s.charAt(i + 1));
            ans += (dp[i][i+1] ? 1 : 0);
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len; j < n; i++, j++) {
                dp[i][j] = (dp[i-1][j-1] && (s.charAt(i) == s.charAt(j)));
                ans += (dp[i][j] ? 1 : 0);
            }
        }

        return ans;
    }


        // Time Complexity: O(N^3) for input string of length N.
    // Since we just need to traverse every substring once, the total time taken is sum of the length of all substrings.

    // Space Complexity: O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.
    public static int countSubstringsBruteForce(String s) {
        int ans = 0;

        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                ans += isPalindrome(s, start, end) ? 1 : 0;
            }
        }

        return ans;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;

            ++start;
            --end;
        }

        return true;
    }
}
