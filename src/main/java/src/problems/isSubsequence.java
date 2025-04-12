package src.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class isSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";

        System.out.println(isSubsequence(s, t));

        System.out.println(isSubsequenceForMultipleSubString(s, t));

        //ToDo: Do DP way of it (edit distance problem - DP problem - similar proble to this. see that - https://leetcode.com/problems/edit-distance/editorial/)

    }

    //https://leetcode.com/problems/is-subsequence/editorial/
    private static boolean isSubsequenceForMultipleSubString(String s, String originalSequence) {
        // precomputation, build the hashmap out of the target string
        HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();

        for (int i = 0; i < originalSequence.length(); ++i) {
            if (letterIndicesTable.containsKey(originalSequence.charAt(i)))
                letterIndicesTable.get(originalSequence.charAt(i)).add(i);
            else {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                letterIndicesTable.put(originalSequence.charAt(i), indices);
            }
        }

        Integer currMatchIndex = -1;
        for (char letter : s.toCharArray()) {
            if (!letterIndicesTable.containsKey(letter))
                return false; // no match, early exit

            boolean isMatched = false;
            // greedy match with linear search
            for (Integer matchIndex : letterIndicesTable.get(letter)) {
                if (currMatchIndex < matchIndex) {
                    currMatchIndex = matchIndex;
                    isMatched = true;
                    break;
                }
            }

            if (!isMatched)
                return false;
        }

        // consume all characters in the source string
        return true;

    }

    //Time Complexity: O(∣T∣)
    //
    //The analysis is the same as the previous approach.
    //Space Complexity: O(1)
    //
    //We replace the recursion with iteration. In the iteration, a constant memory is consumed regardless of the input.
    public static boolean isSubsequence(String s, String sequence) {
        int leftBound = s.length(), rightBound = sequence.length();
        int pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == sequence.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }
}
