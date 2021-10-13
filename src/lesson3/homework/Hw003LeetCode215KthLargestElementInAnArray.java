package lesson3.homework;

import lesson3.onclass.Common;

public class Hw003LeetCode215KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 1;
        Solution solution = new Solution();
        int kthLargest = solution.findKthLargest(nums, k);
    }

    private static class Solution extends Common {
        public int findKthLargest(int[] nums, int k) {
            return findKthLargest(nums, k, 0, nums.length - 1);
        }

        private static int findKthLargest(int[] nums, int k, int left, int right) {
            int pivot = nums[getRandomNumber(left, right)];
            int pivotIndex = dutchFlagPartition(nums, pivot);
            if(pivot == nums[nums.length - k]) {
                return pivot;
            }
            if(pivotIndex > nums.length - k) {
                return findKthLargest(nums, k, left, pivotIndex);
            }
            return findKthLargest(nums, k, pivotIndex, right);
        }
    }
}
