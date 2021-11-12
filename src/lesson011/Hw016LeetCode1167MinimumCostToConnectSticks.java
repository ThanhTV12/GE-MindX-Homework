package lesson011;

import java.util.PriorityQueue;
import java.util.Queue;

public class Hw016LeetCode1167MinimumCostToConnectSticks {
    public static void main(String[] args) {
        int[] sticks = new int[]{2,4,3};
        Solution solution = new Solution();
        int res = solution.connectSticks(sticks);
    }


    /*
     * use heap to store all values
     * Step 1: Push all values into heap (The number in front is always greater than the number after)
     * Step 2: get 2 highest top elements (Because they were stored in the heap so their values are smallest)
     * Step 3: sum 2 elements which we got at step 2
     * Step 4: Push the sum after we sumed at step 3
     * */
    private static class Solution {
        public int connectSticks(int[] sticks) {
            if(sticks.length < 1) {
                return 0;
            }
            Queue<Integer> heap = new PriorityQueue<>();
            for(int i = 0; i < sticks.length; i++) {
                heap.add(sticks[i]);
            }
            int res = 0;
            while (heap.size() > 1) {
                int cost = heap.remove() + heap.remove();
                res += cost;
                heap.add(cost);
            }
            return res;
        }
    }
}
