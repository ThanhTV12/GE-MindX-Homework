package lesson011_2_pointer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Hw019LeetCode703KthLargestElementInAStream {
    class KthLargest {
        Queue<Integer> heap;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>();
            for(int i = 0; i < nums.length; i++) {
                heap.add(nums[i]);
            }
            while(heap.size() > k) {
                heap.remove();
            }
        }

        public int add(int val) {
            heap.add(val);
            while(heap.size() > k) {
                heap.remove();
            }
            return heap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
