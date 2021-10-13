package lesson2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode560SubarraySumEqualsK {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,2,1,2,1};
        int k = 3;
        int totalNumber = solution.subarraySum(nums, k);
    }

    private static class Solution {
        public int subarraySum(int[] nums, int k) {
            // change nums to prefixSum
            for(int i = 1; i < nums.length; i++) {
                nums[i] = nums[i - 1] + nums[i];
            }
            Map<Integer, Integer> mapOfprefixSumBrowsed = new HashMap<>();
            int total = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == k) {
                    total++;
                }
                int numberPrefixSumBrowsedValid = 0;
                if(mapOfprefixSumBrowsed.containsKey(nums[i] - k)) {
                    numberPrefixSumBrowsedValid = mapOfprefixSumBrowsed.get(nums[i] - k);
                    total += numberPrefixSumBrowsedValid;
                }
                if(mapOfprefixSumBrowsed.containsKey(nums[i])) {
                    mapOfprefixSumBrowsed.put(nums[i], mapOfprefixSumBrowsed.get(nums[i]) + 1);
                } else {
                    mapOfprefixSumBrowsed.put(nums[i], 1);
                }
            }
            return total;
        }
    }
}
