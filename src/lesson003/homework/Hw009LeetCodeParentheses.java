package lesson003.homework;

import java.util.Stack;

public class Hw009LeetCodeParentheses {
    public static void main(String[] args) {
        String s = "()[]({}";
        Solution solution = new Solution();
        boolean valid = solution.isValid(s);
    }

    private static class Solution {
        public boolean isValid(String s) {
            Stack<Character> parenthesesStack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                if(!parenthesesStack.isEmpty() && isPairOfParentheses(parenthesesStack.peek(), s.charAt(i))) {
                    parenthesesStack.pop();
                } else {
                    parenthesesStack.push(s.charAt(i));
                }
            }
            return parenthesesStack.isEmpty();
        }

        private boolean isPairOfParentheses(char left, char right) {
            if(left == '(' && right == ')') {
                return true;
            }
            if(left == '{' && right == '}') {
                return true;
            }
            if(left == '[' && right == ']') {
                return true;
            }
            return false;
        }
    }
}
