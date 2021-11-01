package lesson005.homework;

import java.util.HashMap;
import java.util.Map;

public class Hw004LeetCode454Sum2 {
    public static void main(String[] args) {
        int[] nums1  = new int[] {-1, -1};
        int[] nums2  = new int[] {-1, 1};
        int[] nums3  = new int[] {-1, 1};
        int[] nums4  = new int[] {1, -1};
        Solution solution = new Solution();
        int count = solution.fourSumCount(nums1, nums2, nums3, nums4);
    }

    private static class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int count = 0;
            Map<Integer, Integer> total12Map = caculateSumCount(nums1, nums2);
            Map<Integer, Integer> total34Map = caculateSumCount(nums3, nums4);
            for(Integer total12Key : total12Map.keySet()) {
                if(total34Map.containsKey(0 - total12Key)) {
                    count += total12Map.get(total12Key) * total34Map.get(0 - total12Key);
                }
            }
            return count;
        }

        private Map<Integer, Integer> caculateSumCount(int[] leftNums, int[] rightNums) {
            Map<Integer, Integer> sumCountMap = new HashMap();
            for(int i = 0; i < leftNums.length; i++) {
                for(int j = 0; j < rightNums.length; j++) {
                    int total = leftNums[i] + rightNums[j];
                    if(sumCountMap.containsKey(total)) {
                        sumCountMap.put(total, sumCountMap.get(total) + 1);
                        continue;
                    }
                    sumCountMap.put(total, 1);
                }
            }
            return sumCountMap;
        }
    }
}
