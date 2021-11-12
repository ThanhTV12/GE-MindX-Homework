package lesson011;

import java.util.PriorityQueue;
import java.util.Queue;

public class Hw021LeetCode215KthLergestElementInAnArray {
    public static void main(String[] args) {

    }
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums.length == 0 || k == 0) {
                return 0;
            }
            Queue<Integer> heap = new PriorityQueue<>();
            for(int i = 0; i < nums.length; i++) {
                heap.add(nums[i]);
            }
            while(heap.size() > k) {
                heap.remove();
            }
            return heap.remove();
        }
    }
}
