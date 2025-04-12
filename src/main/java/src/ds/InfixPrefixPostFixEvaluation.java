package src.ds;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

//ToDo: try to implement infix to prefix also
// Time and space complexity of this ???
public class InfixPrefixPostFixEvaluation {
    public static final Map<Character, BiFunction<Integer,Integer, Integer>> operator = Map.of(
            '+', (a, b) -> a + b,
            '-', (a, b) -> a - b,
            '*', (a, b) -> a * b,
            '/', (a, b) -> a / b
    );

    private static final Map<Character, Integer> operatorPrecedence = Map.of(
            '+', 1,
            '-', 1,
            '*', 2,
            '/', 2);

    private static final Map<Character, Character> parehnthesesMap =
            Map.of(')', '(', '}', '{', ']', '[');

    public static void main(String[] args) {
        // 2 * 3 + 5 * 4 - 9
        System.out.println(evaluatePostfix("23*54*+9-"));
        System.out.println(evaluatePrefix("-+*23*549"));
        System.out.println(infixToPostfix("A+B*C-D*E"));
        System.out.println(infixToPostfix("((A+B)*C-D)*E"));
        System.out.println(infixToPostfix("A*(B+C)"));

    }

    // infix - A + (B * C)
    //Postfix - ABC*+
    // Time - O(n)
    // space - O(n)
    private static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfixResult = new StringBuilder();

        for (char c: exp.toCharArray()) {
            if (isOperand(c)) {
                postfixResult.append(c);
            } else if (operator.containsKey(c)) {
                while (!stack.isEmpty() && !parehnthesesMap.containsValue(stack.peek()) && hasHigherPrecedence(stack.peek(), c)) {
                    postfixResult.append(stack.pop());
                }
                stack.push(c);
            } else if (parehnthesesMap.containsValue(c)) {
                stack.push(c);
            } else if (parehnthesesMap.containsKey(c)) {
                while (!stack.isEmpty() && !parehnthesesMap.containsValue(stack.peek()))
                    postfixResult.append(stack.pop());
                stack.pop();
            }
        }

        while (!stack.isEmpty())
            postfixResult.append(stack.pop());

        return postfixResult.toString();
    }

    private static boolean hasHigherPrecedence(Character peek, char c) {
        if (!operatorPrecedence.containsKey(peek) || !operatorPrecedence.containsKey(c)) {
            return false;
        }

        return operatorPrecedence.get(peek) >= operatorPrecedence.get(c);

    }

    private static boolean isOperand(char c) {
        return !operator.containsKey(c) && !parehnthesesMap.containsKey(c) && !parehnthesesMap.containsValue(c);
    }

    private static int evaluatePrefix(String s) {
        Stack<Integer> stack = new Stack<>();

        // Start from last
        for (int i = s.length()-1 ; i>=0 ; i--) {
            char c = s.charAt(i);

            if (!operator.containsKey(c)) {
                stack.push(c - '0');
            } else if (operator.containsKey(c)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(operator.get(c).apply(op1, op2));
            }
        }

        return stack.pop();
    }

    private static int evaluatePostfix(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c: s.toCharArray()){
            if (!operator.containsKey(c)) {
                stack.push(c - '0');
            } else if (operator.containsKey(c)){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(operator.get(c).apply(op1, op2));
            }
        }
        return stack.pop();
    }
}
