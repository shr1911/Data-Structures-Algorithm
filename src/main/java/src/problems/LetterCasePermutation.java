package src.problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";

        System.out.println(letterCasePermutation(s));
    }

    //Time Complexity: O(2N∗N), where N is the length of S. This reflects the cost of writing the answer.
    // Loop Through Each Character: The outer loop iterates over each character in the string S, which takes O(n) time.
    //Handling Letters: If a character is a letter, the code creates new permutations by appending both lowercase and uppercase versions of the letter to each existing permutation. This effectively doubles the number of permutations for each letter encountered.
    //Initially, there is 1 permutation.
    //After the first letter, there are 2 permutations.
    //After the second letter, there are 4 permutations.
    //After the third letter, there are 8 permutations.
    //After the kth letter, there are 2^k permutations.
    //Since this process continues for each letter in the string, if there are m letters in the string, the total number of permutations will be 2^m.

    //Space Complexity: O(2N∗N).
    // The space complexity is also O(2^n * n) because the code stores all permutations in memory. The maximum number of permutations is 2^n (when all characters are letters), and each permutation is of length n.
    public static List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c: s.toCharArray()) {
            int n = ans.size();

            if (Character.isLetter(c)) {
                for (int i=0; i<n; i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i=0; i<n; i++) {
                    ans.get(i).append(c);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (StringBuilder sb : ans) {
            result.add(sb.toString());
        }
        return result;
    }
}
