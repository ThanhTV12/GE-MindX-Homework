package lesson001.other;

public class LeetCode53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int result = solution.maxSubArray(nums);
    }

    private static class Solution {
        public int maxSubArray(int[] nums) {
            int result = nums[0];
            int sum = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(sum + nums[i] > sum) {
                    sum = sum + nums[i];
                } else {
                    if(result < sum) {
                        result = sum;
                    }
                    sum = 0;
                }
            }
            return result;
        }
    }
}
