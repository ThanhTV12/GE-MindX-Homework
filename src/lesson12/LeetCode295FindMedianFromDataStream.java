package lesson12;

import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode295FindMedianFromDataStream {


    public static void main(String[] args) {
        MedianFinder finder  = new MedianFinder();
//        finder.addNum(1);
//        finder.addNum(2);
//        ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//[[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
        finder.addNum(6);
        double median = finder.findMedian();
        finder.addNum(10);
        double median1 = finder.findMedian();
        finder.addNum(2);
        double median2 = finder.findMedian();
    }

    static class MedianFinder {

        Queue<Integer> minHeap;
        Queue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        }

        // Step 1
        //  if minHeap is empty push it into minHeap
        //  else
        //    peek a element form minHeap then compare with value if the pop value less than the putting value put it into minHeap         //  else push to maxHeap
        //
        // step 2: balacing 2 heaps
        // If the minHeap Size + 1 more than the maxHeap Size . pop a element from minHeap and push it into maxheap


        public void addNum(int num) {
            //Step 1
            if(minHeap.size() == 0) {
                minHeap.add(num);
                return;
            }
            if(minHeap.peek() < num) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
            //Step 2
            if(minHeap.size() + 1 > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            }
            if(maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }
        }

        // minHeap size == maxHeap szie, pops 2 element from 2 heaps and caculate avarage of them
        // minHeap size != maxHeap szie pop 1 element from minHeap and return
        public double findMedian() {
            if(minHeap.size() != maxHeap.size()) {
                return minHeap.peek();
            }
            return (1.0 * minHeap.peek() + maxHeap.peek()) / 2;
        }
    }
}
