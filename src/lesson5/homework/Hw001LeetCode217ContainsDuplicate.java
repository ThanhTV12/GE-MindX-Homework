package lesson5.homework;

import java.util.HashMap;
import java.util.Map;

public class Hw001LeetCode217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean reulst = solution.containsDuplicate(new int[]{1, 2, 3, 1, 4});
    }

    private static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Boolean> map = new HashMap();
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i])) {
                    return true;
                }
                map.put(nums[i], true);
            }
            return false;
        }
    }
}
