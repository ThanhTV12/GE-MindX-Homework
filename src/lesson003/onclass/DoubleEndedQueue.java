package lesson003.onclass;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleEndedQueue {
    public static void main(String[] args) {
        SlidingWindow window = new SlidingWindow();
        int[] nums = {-1, 9, 8, 7, 6, 1, 3, 5, 0};
        int k = 3;
        int[] slide = window.slide(nums, k);
    }

    private static class SlidingWindow {

        private Deque<Integer> slideQueue = new ArrayDeque<>();
        private int[] nums;
        int k;

        public int[] slide(int[] nums, int k) {
            if(nums.length < 2) {
                return nums;
            }
            this.nums = nums;
            this.k = k;
            if(nums.length < k) {
                int max = nums[0];
                for(int i = 1; i < nums.length; i++) {
                    if(max < nums[i]) {
                        max = nums[i];
                    }
                }
                return new int[]{max};
            }
            int[] slide = new int[nums.length - k + 1];
            int sideIndex = 0;
            for(int i = 0; i < nums.length; i++) {
                push(i);
                if(i + 1 >= k) {
                    slide[sideIndex++] = nums[slideQueue.getFirst()];
                }
            }
            return slide;
        }

        private void push(int i) {
            //clear if item is out of slide
            if(!slideQueue.isEmpty() && i - k == slideQueue.getFirst()) {
                slideQueue.removeFirst();
            }
            while (!slideQueue.isEmpty() && nums[slideQueue.getLast()] <= nums[i]) {
                slideQueue.removeLast();
            }
            slideQueue.addLast(i);
        }
    }

    private static class Solution {
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        int [] nums;

        public void clean_deque(int i, int k) {
            // remove indexes of elements not from sliding window
            if (!deq.isEmpty() && deq.getFirst() == i - k)
                deq.removeFirst();

            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
                deq.removeLast();
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            // init deque and output
            this.nums = nums;
            int max_idx = 0;
            for (int i = 0; i < k; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                // compute max in nums[:k]
                if (nums[i] > nums[max_idx]) {
                    max_idx = i;
                }
            }
            int [] output = new int[n - k + 1];
            output[0] = nums[max_idx];

            // build output
            for (int i  = k; i < n; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }
    }
}
