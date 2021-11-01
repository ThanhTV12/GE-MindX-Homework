package lesson001.homework;

import java.util.HashSet;
import java.util.Set;

public class Problem12LeetCode202HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //boolean isHappy = solution.isHappyV2(1111111);
        boolean isHappy = solution.isHappyV2(19);
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
            int remainder  = 0;
            while (n > 0) {
                remainder  = n % 10;
                sum += remainder  * remainder;
                n = n / 10;
            }
            return sum;
        }

        //use Floyd Algorithm - fast and slow pointer
        public boolean isHappyV2(int n) {
            int fastSum = n;
            int slowSum = n;
            do {
                slowSum = sumOfSquaresOfDigits(slowSum);
                fastSum = sumOfSquaresOfDigits(sumOfSquaresOfDigits(fastSum));
                if(slowSum == 1 || fastSum == 1) {
                    return true;
                }
            } while (fastSum != slowSum);  //it contains a cycle - loops endlessly in a cycle
            return false;
        }
    }
}
