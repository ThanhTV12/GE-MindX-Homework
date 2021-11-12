package lesson011;

import java.util.Arrays;

public class Hw007LeetCode259H3SumSmaller {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,3};
        int target = 2;
        Solution solution = new Solution();
        int i = solution.threeSumSmaller(nums, target);
    }
    private static class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int res = 0;
            for(int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right) {
                    if(nums[i] + nums[left] + nums[right] < target) {
                        res += right - left;
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }
    }
}
