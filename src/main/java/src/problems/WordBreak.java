package src.problems;

import java.util.*;

class TrieDictNode {
    boolean isWord;
    Map<Character, TrieDictNode> children;

    TrieDictNode() {
        this.children = new HashMap<>();
    }
}

public class WordBreak {
    private static String s;
    private static List<String> wordDict;
    private static int[] memo;

    
    public static void main(String[] args) {

    }

    // Time complexity: O(n^2 + m⋅k)
    // Building the trie involves iterating over all characters of all words. This costs O(m⋅k).
    // Once we build the trie, we calculate dp. For each i, we iterate over all the indices after i. We have a basic nested for loop which costs O(n^2) to handle all dp[i].
    //
    // Space complexity: O(n+m⋅k)
    // The dp array takes O(n) space. The trie can have up to m⋅k nodes in it.
    public boolean wordBreakTrie(String s, List<String> wordDict) {
        TrieDictNode root = new TrieDictNode();
        for (String word : wordDict) {
            TrieDictNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieDictNode());
                }

                curr = curr.children.get(c);
            }

            curr.isWord = true;
        }

        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || dp[i - 1]) {
                TrieDictNode curr = root;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (!curr.children.containsKey(c)) {
                        // No words exist
                        break;
                    }

                    curr = curr.children.get(c);
                    if (curr.isWord) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }


    // Time complexity: O(n⋅m⋅k)
    // There are n states of dp(i). Because of memoization, we only calculate each state once. To calculate a state, we iterate over m words, and for each word perform some substring operations which costs O(k). Therefore, calculating a state costs O(m⋅k), and we need to calculate O(n) states.

    // Space complexity: O(n)
    // The data structure we use for memoization and the recursion call stack can use up to O(n) space.
    public static boolean wordBreakDP(String inputStr, List<String> wordDictionary) {
        s = inputStr;
        wordDict = wordDictionary;
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s.length() - 1);
    }

    private static boolean dp(int i) {
        if (i < 0) return true;

        if (memo[i] != -1) {
            return memo[i] == 1;
        }

        for (String word: wordDict) {
            // Handle out of bounds case
            if (i - word.length() + 1 < 0) {
                continue;
            }

            if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp (i - word.length())) {
                memo[i] = 1;
                return true;
            }
        }

        memo[i] = 0;
        return false;
    }

    // Time complexity: O(n^3 + m⋅k)
    //
    //There are O(n) nodes. Because of seen, we never visit a node more than once. At each node, we iterate over the nodes in front of the current node, of which there are O(n). For each node end, we create a substring, which also costs O(n).
    //Therefore, handling a node costs O(n^2), so the BFS could cost up to O(n ^3). Finally, we also spent O(m⋅k) to create the set words.

    // Space complexity: O(n+m⋅k)
    //
    //We use O(n) space for queue and seen. We use O(m⋅k) space for the set words.
    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }
}
