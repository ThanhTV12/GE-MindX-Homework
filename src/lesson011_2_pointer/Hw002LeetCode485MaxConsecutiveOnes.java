package lesson011_2_pointer;

public class Hw002LeetCode485MaxConsecutiveOnes {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int res = 0;
            int left = 0;
            int right = 0;
            while(right < nums.length) {
                while(right < nums.length - 1 && nums[right + 1] == 1) {
                    right++;
                    if(nums[left] == 0) {
                        left = right;
                    }
                }
                if(nums[left] == 1) {
                    int length = right - left + 1;
                    if(length > res) {
                        res = length;
                    }
                }
                right++;
                left = right;
            }
            return res;
        }
    }
}
