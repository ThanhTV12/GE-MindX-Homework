package Lesson22_sercurity.algorithm;

public class LeetCode121BestTimeTBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int left = 0;
            int right = 1;
            int max = 0;
            while(left < prices.length - 1 && right < prices.length) {
                max = Math.max(max, prices[right] - prices[left]);
                if(prices[left] >= prices[right]) {
                    left = right;
                }
                right++;
            }
            return max;
        }
    }
}
