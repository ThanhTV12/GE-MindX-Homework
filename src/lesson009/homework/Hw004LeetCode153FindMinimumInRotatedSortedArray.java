package lesson009.homework;

public class Hw004LeetCode153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int min = solution.findMin(new int[]{3,1,2});
    }
    private static class Solution {
        public int findMin(int[] nums) {
            int lo = 0;
            int hi = nums.length - 1;
            while(lo <= hi) {
                if(nums[lo] <= nums[hi]) {
                    return nums[lo];
                }
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] >= nums[0]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return -1;
        }
    }
}
