package lesson1.homework;

import java.util.HashSet;
import java.util.Set;

public class Problem12LeetCode202HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean isHappy = solution.isHappy(1111111);
    }

    private static class Solution {
        Set<Integer> setOfSum;
        public boolean isHappy(int n) {
            if(setOfSum == null) {
                setOfSum = new HashSet<>();
            }
            int sum = sumOfSquaresOfDigits(n);
            if(setOfSum.contains(sum)) {
                setOfSum = null;
                return false;
            }
            setOfSum.add(sum);
            if(sum == 1) {
                setOfSum = null;
                return true;
            }
            return isHappy(sum);
        }

        private int sumOfSquaresOfDigits(int n) {
            int sum = 0;
            int rest = 0;
            while (n > 0) {
                rest = n % 10;
                sum += rest * rest;
                n = n / 10;
            }
            return sum;
        }
    }
}
