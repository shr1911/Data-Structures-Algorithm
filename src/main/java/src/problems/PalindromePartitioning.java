package src.problems;

import java.util.ArrayList;
import java.util.List;

// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partitionBacktracking("aab"));

    }



    public static List<List<String>> partitionBacktrackingDP(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<List<String>>();
        dfsDP(result, s, 0, new ArrayList<String>(), dp);
        return result;
    }

    // Time Complexity : O(N⋅2^N), where N is the length of the string s. In the worst case, there could be 2^N possible substrings and it will take O(N) to generate each substring using substr as in Approach 1. However, we are eliminating one additional iteration to check if the substring is a palindrome or not.
    //
    //Space Complexity: O(N⋅N), where N is the length of the string s. The recursive call stack would require N space as in Approach 1. Additionally we also use 2 dimensional array dp of size N⋅N .
    //This gives us a total space complexity of O(N⋅N) + O(N) = O(N⋅N)
    public static void dfsDP(List<List<String>> result, String s, int start, List<String> currentList,  boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (
                    s.charAt(start) == s.charAt(end) &&
                            (end - start <= 2 || dp[start + 1][end - 1])
            ) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfsDP(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }


    public static List<List<String>> partitionBacktracking(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }

    //Time Complexity : O(N⋅2^N), where N is the length of string s. This is the worst-case time complexity when all the possible substrings are palindrome.
    //Hence, there could be 2^N possible substrings in the worst case. For each substring, it takes O(N) time to generate the substring and determine if it is a palindrome or not. This gives us a time complexity of O(N⋅2^N)

    //Space Complexity: O(N), where N is the length of the string s. This space will be used to store the recursion stack. For s = aaa, the maximum depth of the recursive call stack is 3 which is equivalent to N.
    private static void dfs(int start, List<List<String>> result, ArrayList<String> currentList, String s) {
        if (start >= s.length())
            result.add(new ArrayList<String>(currentList));

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
