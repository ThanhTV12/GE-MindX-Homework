package lesson19;

public class LeetCode1262GreatestSumDivisibleByThree {

    public static void main(String[] args) {
        int[] nums = new int[] {3,6,5,1,8};
        Solution solution = new Solution();
        int i = solution.maxSumDivThree(nums);
    }

    static class Solution {
        public int maxSumDivThree(int[] nums) {
            int[][] maxSums = new int[nums.length][3];
            //base case
            maxSums[0][nums[0] % 3] = nums[0];
            for(int i = 1 ; i < nums.length; i++) {
                for(int k = 0; k < 3; k++) {
                    int sum = maxSums[i - 1][k] + nums[i];
                    maxSums[i][sum % 3] = Math.max(maxSums[i][sum % 3], sum); // caculate value depends on the previous values
                    maxSums[i][k] = Math.max(maxSums[i - 1][k], maxSums[i][k]);
                }
            }
            return maxSums[nums.length - 1][0];
        }
    }
}
