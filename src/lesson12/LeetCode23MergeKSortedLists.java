package lesson12;

import general.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode23MergeKSortedLists {
    public static void main(String[] args) {
        // [[1,4,5],[1,3,4],[2,6]]

    }


    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int k = lists.length;
            if(k == 0) {
                return null;
            }
            Queue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
            for(int i = 0; i < k; i++) {
                if(lists[i] != null) {
                    heap.add(lists[i]);
                }
            }
            if(heap.isEmpty()) {
                return null;
            }
            ListNode res = heap.remove();
            ListNode current  = res;
            while(true) {
                if(current.next != null) {
                    heap.add(current.next);
                }
                if(heap.size() == 0) {
                    break;
                }
                ListNode next = heap.remove();
                current.next = next;
                current = next;
            }
            return res;
        }
    }
}
