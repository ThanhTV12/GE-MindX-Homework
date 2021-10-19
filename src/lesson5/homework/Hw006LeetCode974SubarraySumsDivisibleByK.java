package lesson5.homework;

import java.util.HashMap;
import java.util.Map;

public class Hw006LeetCode974SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 2, 9};
        int k = 5;
        Solution solution = new Solution();
        int count = solution.subarraysDivByK(nums, k);
    }
    
    private static class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int count = 0;
            int sum = 0;
            Map<Integer, Integer> remainderMap  = new HashMap();
            for(int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                int remainder = sum % k;
                if(remainder == 0) {
                    count++;
                }
                if(remainder < 0) {
                    remainder = k + remainder;
                }
                if(remainderMap.containsKey(remainder)) {
                    count = count + remainderMap.get(remainder);
                    remainderMap.put(remainder, remainderMap.get(remainder) + 1);
                } else {
                    remainderMap.put(remainder, 1);
                }
            }
            return count;
        }
    }
}
