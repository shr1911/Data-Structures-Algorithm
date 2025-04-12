package src.problems;

import java.util.*;


// WORST CASE SCENARIO
// Then we iterate over O(m2) index pairs. At each index pair, we perform a substring operation and check if that substring is in the hash set, which costs up to O(m). Thus, this iteration costs O(m3).
public class IndexPairsOfString {
    public static void main(String[] args) {
        String text = "thestoryofleetcodeandme";
        String[] words = {"story","fleet","leetcode"};

        System.out.println(Arrays.deepToString(indexPairs(text, words)));
    }

    //Let m denote text.length, n denote words.length, and s as the average length of the words.
    //
    //Time complexity: O(n⋅s+m2).
    //Just like in the previous approach, we need O(n⋅s) to build our data structure (the trie). Then, we iterate over O(m2) index pairs. This time, instead of performing O(m) substring operations at each index pair, we only need O(1). This gives us a total time complexity of O(n⋅s+m2).
    //
    //Note that this time complexity is only in the worst case, and in reality, this algorithm will be much more efficient because most index pairs will be skipped.
    //
    //Space complexity: O(n⋅s).
    //In the worst case scenario, each letter of each word in words will have its own node in the trie. There are n⋅s total letters.
    public static int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<int[]> result = new ArrayList();
        for (int i = 0; i < text.length(); i++) {
            TrieNode p = trie.root;
            for (int j = i; j < text.length(); j++) {
                if (p.next.get(text.charAt(j)) == null) {
                    break;
                }
                p = p.next.get(text.charAt(j));
                if (p.flag) {
                    result.add(new int[] { i, j });
                }
            }
        }
        int[][] ans = new int[result.size()][];
        ans = result.toArray(ans);
        return ans;
    }
}


class TrieNode {
    public boolean flag;
    public Map<Character, TrieNode> next = new HashMap<>();
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
        }
        cur.flag = true;
    }
}
