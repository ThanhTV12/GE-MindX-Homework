package lesson1.homework;

import java.util.List;

public class Problem8LeetCode206ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;

        ListNode item2 = new ListNode();
        item2.val = 2;
        head.next = item2;

        ListNode item3 = new ListNode();
        item3.val = 3;
        item2.next = item3;

        ListNode item4 = new ListNode();
        item4.val = 4;
        item3.next = item4;

        ListNode item5 = new ListNode();
        item5.val = 5;
        item4.next = item5;

        Solution solution = new Solution();
        ListNode listNode = solution.reverseListRecursion(head);

    }

    private static class Solution {
        public ListNode reverseListIterative(ListNode head) {
            ListNode previous = null;
            ListNode itemPointed = head;
            ListNode next = itemPointed;
            while (next != null) {
                itemPointed = next;
                next = next.next;
                itemPointed.next = previous;
                previous = itemPointed;
            }
            return itemPointed;
        }

        public ListNode reverseListRecursion(ListNode item) {
            if(item == null || item.next == null) {
                return item;
            }
            ListNode parent = reverseListRecursion(item.next);
            //parent.next = item;
            item.next.next = item;
            item.next = null;
            return parent;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
