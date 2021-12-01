package lesson011_2_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hw008 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        int target = 0;
        List<List<Integer>> lists = solution.fourSum(nums, target);
    }


    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList();
            for(int i = 0; i < nums.length - 3; i++) {
                if(i != 0 && nums[i- 1] == nums[i]) {
                    continue;
                }
                for(int j = i + 1; j < nums.length - 2; j++) {
                    if(j != i + 1 && nums[j- 1] == nums[j]) {
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while(left < right) {
                        if(nums[i] + nums[j] + nums[left] + nums[right] == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            left++;
                        } else if(nums[i] + nums[j] + nums[left] + nums[right] < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return res;
        }
    }
}
