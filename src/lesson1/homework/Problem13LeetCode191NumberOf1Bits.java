package lesson1.homework;

public class Problem13LeetCode191NumberOf1Bits {

    public static void main(String[] args) {
        Solution solution  = new Solution();
        solution.hammingWeight(19);
    }

    private static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int numberOf1Bits = 0;
            while (n != 0) {
                n = n & (n -1);
                numberOf1Bits++;
            }
            return numberOf1Bits;
        }
    }
}


