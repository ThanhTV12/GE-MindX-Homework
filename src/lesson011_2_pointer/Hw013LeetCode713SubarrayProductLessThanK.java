package lesson011_2_pointer;

public class Hw013LeetCode713SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        int k = 18;
        int i = solution.numSubarrayProductLessThanK(nums, k);
    }

    private static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int left = 0;
            int right = 0;
            int res = 0;
            int product = 1;
            while(left < nums.length) {
                if(nums[left] > k) {
                    left++;
                    right = left;
                    continue;
                }
                if(right < nums.length - 1 && product * nums[right + 1] < k) {
                    product = product * nums[right + 1];
                    right++;
                } else if(product < k){
                    res += right - left + 1;
                    product = product / nums[left];
                    left++;
                } else {
                    right++;
                    left = right;
                }
            }
            return res;
        }
    }
}
