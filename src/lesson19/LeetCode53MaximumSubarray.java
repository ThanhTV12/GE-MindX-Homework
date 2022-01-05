package lesson19;

public class LeetCode53MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int cur = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(cur + nums[i] > nums[i]) {
                    cur = cur + nums[i];
                } else {
                    cur = nums[i];
                }
                if(cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }
}
