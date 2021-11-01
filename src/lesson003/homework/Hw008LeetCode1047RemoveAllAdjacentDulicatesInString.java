package lesson003.homework;


import java.util.Stack;

public class Hw008LeetCode1047RemoveAllAdjacentDulicatesInString {
    public static void main(String[] args) {
        String s = "abbaca";
        Solution solution = new Solution();
        String result = solution.removeDuplicatesV2(s);
    }

    private static class Solution {
        public String removeDuplicates(String s) {
            Stack<Character> builderStack = new Stack();
            for(int i = 0; i < s.length(); i++) {
                if(!builderStack.isEmpty() && builderStack.peek() == s.charAt(i)) {
                    builderStack.pop();
                } else {
                    builderStack.push(s.charAt(i));
                }
            }
            String result = "";
            while (!builderStack.isEmpty()) {
                result = builderStack.pop() + result;
            }
            return result;
        }


        /*
         * Use a StringBuilder like a stack
         *
         * */
        public String removeDuplicatesV2(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            int lastIndexOfResult = -1;
            for(int i = 0; i < s.length(); i++) {
                if((lastIndexOfResult > -1) && stringBuilder.charAt(lastIndexOfResult) == s.charAt(i)) {
                    stringBuilder.deleteCharAt(lastIndexOfResult--);
                } else {
                    stringBuilder.append(s.charAt(i));
                    lastIndexOfResult++;
                }
            }
            return stringBuilder.toString();
        }
    }
}
