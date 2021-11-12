package lesson011;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hw020LeetCode347TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 4, 4, 4, 4,4, 2,2, 1, 1, 3, 2};
        int k = 2;
        Solution solution = new Solution();
        int[] res = solution.topKFrequent(nums, k);
    }

    private static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> eleAndFrequency = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(eleAndFrequency.containsKey(nums[i])) {
                    eleAndFrequency.put(nums[i],eleAndFrequency.get(nums[i]) + 1);
                } else {
                    eleAndFrequency.put(nums[i], 1);
                }
            }
            Queue<Item> heap = new PriorityQueue<>();
            for(Integer ele : eleAndFrequency.keySet()) {
                heap.add(new Item(ele, eleAndFrequency.get(ele)));
            }
            while (heap.size() > k) {
                heap.remove();
            }
            int[] res = new int[heap.size()];
            int index = 0;
            while (!heap.isEmpty()) {
                res[index++] = heap.remove().ele;
            }
            return res;
        }
    }

    private static class Item implements Comparable<Item> {
        public int ele;
        public int count;

        public Item(int ele, int count) {
            this.ele = ele;
            this.count = count;
        }

        @Override
        public int compareTo(Item item) {
            if(this.count > item.count) {
                return 1;
            }
            if(this.count < item.count) {
                return -1;
            }
            return 0;
        }
    }
}
