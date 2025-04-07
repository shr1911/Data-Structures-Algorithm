package org.problems;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String first = "ab#c", second = "ad#c";

        System.out.println(backspaceCompare(first, second));
    }

    // Time complexity - O(n)
    // space complexity - O(1)
    public static boolean backspaceCompare(String first, String second) {
        int firstIndex = first.length() - 1;
        int secondIndex = second.length() - 1;
        int skipFirst = 0, skipSecond = 0;


        while (firstIndex >= 0 || secondIndex >= 0) {
            while (firstIndex >= 0) {
                if (first.charAt(firstIndex) == '#') {skipFirst++; firstIndex--;}
                else if (skipFirst > 0) {skipFirst--; firstIndex--;}
                else break;
            }
            while (secondIndex >= 0) {
                if (second.charAt(secondIndex) == '#') {skipSecond++; secondIndex--;}
                else if (skipSecond > 0) {skipSecond--; secondIndex--;}
                else break;
            }

            if (firstIndex >= 0 && secondIndex >= 0 && first.charAt(firstIndex) != second.charAt(secondIndex)) return false;

            if ((firstIndex >= 0) != (secondIndex >= 0)) return false;

            firstIndex--; secondIndex--;
        }
        return true;
    }
}



