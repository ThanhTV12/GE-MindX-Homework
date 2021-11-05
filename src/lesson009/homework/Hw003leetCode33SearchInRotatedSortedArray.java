package lesson009.homework;

public class Hw003leetCode33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int search = solution.search(new int [] {4,5,6,7,0,1,2}, 2);
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] == target) {
                    return mid;
                }
                if(target >= nums[0]) {
                    if(nums[mid] >= nums[0]) {
                        if(nums[mid] > target) {
                            hi = mid - 1;
                        } else {
                            lo = mid + 1;
                        }
                    } else {
                        hi = mid - 1;
                    }
                } else {
                    if(nums[mid] >= nums[0]) {
                        lo = mid + 1;
                    } else {
                        if(nums[mid] > target) {
                            hi = mid - 1;
                        } else {
                            lo = mid + 1;
                        }
                    }
                }
            }

            return -1;
        }
    }
}
