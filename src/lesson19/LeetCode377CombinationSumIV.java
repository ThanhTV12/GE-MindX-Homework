package lesson19;

public class LeetCode377CombinationSumIV {
    //DP
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] ways = new int[target + 1];
            for(int i = 1; i < target + 1; i++) {
                for(int k = 0; k < nums.length; k++) {
                    if(nums[k] < i) {
                        ways[i] = ways[i] + ways[i - nums[k]];
                    }
                    if(nums[k] == i) {
                        ways[i] = ways[i] + 1;
                    }
                }
            }
            return ways[target];
        }
    }
}
