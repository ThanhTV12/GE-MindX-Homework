package lesson1.homework;

public class Problem14LeetCode231PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean isPowerOfTwo = solution.isPowerOfTwo(15);
    }
    
    private static class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n <= 0) {
                return false;
            }
            if((n & (n - 1)) == 0) {
                return true;
            }
            return false;
        }
    }
}
