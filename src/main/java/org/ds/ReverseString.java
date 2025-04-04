package org.ds;


import java.util.Arrays;
import java.util.Stack;

/**
 * Time complexity - O(n)
 * space complexity stack space - O(n)
 */
public class ReverseString {
    public static void main(String[] args) {

        String input = "Shraddha";
        char[] inputCharArray = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<input.length(); i++) {
            stack.push(inputCharArray[i]);
        }

        for (int i=0; i<input.length(); i++) {
            inputCharArray[i] = stack.pop();
        }

        System.out.println(Arrays.toString(inputCharArray));

        // Without using extra space
        int j = inputCharArray.length - 1;
        for (int i=0; i<j ; i++, j--) {
            char temp = inputCharArray[i];
            inputCharArray[i] = inputCharArray[j];
            inputCharArray[j] = temp;
        }

        System.out.println(Arrays.toString(inputCharArray));

    }
}
