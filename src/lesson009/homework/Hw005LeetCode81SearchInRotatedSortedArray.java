package lesson009.homework;

public class Hw005LeetCode81SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean search = solution.search(new int[]{1,0, 1, 1, 1}, 0);
    }


    private static class Solution {
        public boolean search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] == target) {
                    return true;
                }
                //check wether is support Binary search or not
                if(nums[mid] == nums[lo]) {
                    lo++;
                    continue;
                }
                if(nums[mid] > nums[0]) {
                    if(target >= nums[lo] && target < nums[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    if(target > nums[mid] && target <= nums[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
            return false;
        }
    }
}
