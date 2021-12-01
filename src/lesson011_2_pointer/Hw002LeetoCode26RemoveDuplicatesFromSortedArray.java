package lesson011_2_pointer;

public class Hw002LeetoCode26RemoveDuplicatesFromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int left = 0;
            int right = 0;
            while(right < nums.length) {
                if(nums[left] < nums[right]) {
                    nums[++left] = nums[right];
                } else {
                    right++;
                }
            }
            return left + 1;
        }
    }
}
