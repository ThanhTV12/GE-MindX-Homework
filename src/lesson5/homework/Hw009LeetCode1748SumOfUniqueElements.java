package lesson5.homework;

import java.util.HashMap;
import java.util.Map;

public class Hw009LeetCode1748SumOfUniqueElements {
    class Solution {
        public int sumOfUnique(int[] nums) {
            int total = 0;
            Map<Integer, Integer> mapOfNum = new HashMap();
            for(int i = 0; i < nums.length; i++) {
                if(mapOfNum.containsKey(nums[i])) {
                    total = total - mapOfNum.get(nums[i]) * nums[i];
                    mapOfNum.put(nums[i], 0);
                } else {
                    total += nums[i];
                    mapOfNum.put(nums[i], 1);
                }
            }
            return total;
        }
    }
}
