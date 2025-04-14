package src.problems;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        System.out.println(generateAbbreviations("word"));
    }


    // Time complexity: O(N×2^N).
    // Each of the N characters in the string word has two choices that we will make until we do it for all the characters. Also, for each string produced, we are appending the abbreviatedString during the process which adds another O(N) time. Since we are going to generate 2^N strings, therefore the time complexity is equal to O(2^N).

    // Space complexity: O(N).
    // The space used to store the output is generally not considered part of the space complexity. Thus, the only space required is the stack space, the maximum number of active function calls in the stack will be equal to N one for each character in the string word. Hence, the space complexity is equal to O(N).
    public static List<String> generateAbbreviations(String word) {
        List<String> answerAbbreviations = new ArrayList<>();
        storeAbbreviations(answerAbbreviations, word, new StringBuilder(), 0, 0);
        return answerAbbreviations;
    }

    private static void storeAbbreviations(
            List<String> answerAbbreviations, String word, StringBuilder currWord, int index, int abbreviatedCount){
        if (index == word.length()) {
            // If the length of the last abbreviated substring is 0, add an empty string.
            if (abbreviatedCount > 0) {
                currWord.append(abbreviatedCount);
            }
            answerAbbreviations.add(currWord.toString());
            return;
        }

        int currWordLength = currWord.length();
        // Option 1: Keep the current character.
        if (abbreviatedCount > 0) {
            currWord.append(abbreviatedCount);
        }

        currWord.append(word.charAt(index));
        storeAbbreviations(answerAbbreviations, word, currWord, index + 1, 0);
        currWord.setLength(currWordLength); // Backtrack
        // Option 2: Abbreviate the current character.
        storeAbbreviations(answerAbbreviations, word, currWord, index + 1, abbreviatedCount + 1);
    }
}
