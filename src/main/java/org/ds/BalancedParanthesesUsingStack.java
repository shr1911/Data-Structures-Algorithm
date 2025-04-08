package org.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesesUsingStack {
    public static final Map<Character, Character> paranthesesMap =
            Map.of(')', '(', '}', '{', ']', '[');
    public static void main(String[] args) {
        System.out.println(checkBalanceParantheses("(A+B)"));
        System.out.println(checkBalanceParantheses("{([A]+B)}"));
        System.out.println(checkBalanceParantheses("{([A + B)}"));


    }

    private static boolean checkBalanceParantheses(String expression) {
        // (A + B)
        Stack<Character> stack = new Stack<>();

        for (char i : expression.toCharArray()){
            if (paranthesesMap.containsValue(i)){
                stack.push(i);
            } else if (paranthesesMap.containsKey(i)) {
                if (stack.isEmpty() || !paranthesesMap.get(i).equals(stack.peek())){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
