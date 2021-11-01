package lesson002;

public class LeetCode53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = new int[] {-2 ,1};
        int i = solution.maxSubArray(nums);
    }

    //Dynamic Programming, Kadane's Algorithm
    private static class Solution {
        public int maxSubArray(int[] nums) {
            int totalCurrentSubArray = nums[0];
            int maxSubArray = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if((totalCurrentSubArray + nums[i]) < nums[i]) {
                    totalCurrentSubArray = nums[i];
                } else {
                    totalCurrentSubArray += nums[i];
                }
                if(maxSubArray < totalCurrentSubArray) {
                    maxSubArray = totalCurrentSubArray;
                }
            }
            return maxSubArray;
        }
    }
}
