package lesson003.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hw007LeetCode239SlidingWindowMaximum {

    class Solution {

        private Deque<Integer> slideQueue = new ArrayDeque<>();
        private int[] nums;
        int k;

        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length < 2) {
                return nums;
            }
            this.nums = nums;
            this.k = k;
            /*  findMax if size of nums <= k
             *  iterate through all nums values to find the maximum
             *
             */
            if(nums.length <= k) {
                int max = nums[0];
                for(int i = 1; i < nums.length; i++) {
                    if(max < nums[i]) {
                        max = nums[i];
                    }
                }
                return new int[]{max};
            }
            /*  - if size of nums is longer than k
             *  - use a double ended queue (deque)
             *  - The index of maximum is got from the head of the deque
             *  - remove all items from the head if they are out block (we just get k element to compare)
             *  at here, we get indexes from the head if the value less than or equal i - k. remove them
             *  - interval push indexes to the tail of deque. But indexes pushed is less than we must remove them before pushing
             *  because They can't be a maximum.
             *
             * */
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
}
