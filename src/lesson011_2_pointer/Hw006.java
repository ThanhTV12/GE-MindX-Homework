package lesson011_2_pointer;

import java.util.Arrays;

public class Hw006 {
    class Solution {
        public int twoSumLessThanK(int[] nums, int k) {
            Arrays.sort(nums);
            int lo = 0;
            int high = nums.length - 1;
            int res = -1;
            while(lo < high) {
                int sum = nums[lo] + nums[high];
                if(sum < k) {
                    if(res < sum) {
                        res = sum;
                    }
                    lo++;
                } else {
                    high--;
                }
            }
            return res;
        }
    }
}
