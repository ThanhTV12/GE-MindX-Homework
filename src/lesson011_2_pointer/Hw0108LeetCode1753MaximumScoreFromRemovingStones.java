package lesson011_2_pointer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Hw0108LeetCode1753MaximumScoreFromRemovingStones {
    //Max heap
    //time : O(alog(a) + blog(b) + clog(c))
    class Solution {
        public int maximumScore(int a, int b, int c) {
            Queue<Integer> heap = new PriorityQueue<>((a1, b1) -> b1 - a1);
            heap.add(a);
            heap.add(b);
            heap.add(c);
            int res = 0;
            while(heap.size() > 1) {
                int first = heap.remove();
                int second = heap.remove();
                if(--first > 0) {
                    heap.add(first);
                }
                if(--second > 0) {
                    heap.add(second);
                }
                res++;
            }
            return res;
        }
    }
}
