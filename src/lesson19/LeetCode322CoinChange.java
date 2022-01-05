package lesson19;

import java.util.Arrays;

public class LeetCode322CoinChange {
    // Dynamic program - bottom up
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] numbers = new int[amount + 1];
            //base case
            Arrays.fill(numbers, amount + 1);
            numbers[0] = 0;
            for(int i = 1; i < amount + 1; i++) {
                for(int k = 0; k < coins.length; k++) {
                    if(i >= coins[k]) {
                        numbers[i] = Math.min(numbers[i], numbers[i - coins[k]] + 1);
                    }
                }
            }
            if(numbers[amount] <= amount) {
                return numbers[amount];
            }
            return -1;
        }
    }
}
