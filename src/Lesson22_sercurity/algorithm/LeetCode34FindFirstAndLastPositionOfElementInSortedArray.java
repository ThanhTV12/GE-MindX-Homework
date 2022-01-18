package Lesson22_sercurity.algorithm;

public class LeetCode34FindFirstAndLastPositionOfElementInSortedArray {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = -1;
            int end = -1;
            // find start
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == target) {
                    start = i;
                    break;
                }
            }
            if(start == -1) {
                return new int[]{-1 , -1};
            }
            end = start;
            for(int i = end + 1; i < nums.length; i++) {
                if(nums[i] != target) {
                    break;
                }
                end = i;
            }
            return new int[] {start, end};
        }
    }
}
