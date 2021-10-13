package lesson3.homework;

import java.util.Stack;

public class Hw010EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[] {"2","1","+","3","*"};
        Solution solution = new Solution();
        solution.evalRPN(tokens);
    }

    private static class Solution {

        public int evalRPN(String[] tokens) {
            Stack<String> notationStack = new Stack();
            for(String token : tokens) {
                if(isOperative(token)) {
                    String argument2 = notationStack.pop();
                    String argument1 = notationStack.pop();
                    notationStack.push(String.valueOf(caculate(argument1, argument2, token)));
                } else {
                    notationStack.push(token);
                }
            }
            return Integer.parseInt(notationStack.pop());
        }

        private boolean isOperative(String token) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    return true;
                default:
                    return false;
            }
        }

        private int caculate(String argument1, String argument2, String operator) {
            switch (operator) {
                case "+":
                    return Integer.parseInt(argument1) +  Integer.parseInt(argument2);
                case "-":
                    return Integer.parseInt(argument1) -  Integer.parseInt(argument2);
                case "*":
                    return Integer.parseInt(argument1) * Integer.parseInt(argument2);
                case "/":
                    return Integer.parseInt(argument1) / Integer.parseInt(argument2);
                default:
                    return 0;
            }
        }
    }
}
