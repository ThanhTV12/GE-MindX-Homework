package lesson3.homework;

import general.ListNode;

public class Hw002LeetCode148SortList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        ListNode sorted = solution.sortList(node1);
    }

    private static class Solution {

        public ListNode sortList(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            if(head == null || head.next == null) {
                return head;
            }
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode rightSorted = sortList(slow.next);
            slow.next = null;
            ListNode leftSorted = sortList(head);
            return merge(leftSorted, rightSorted);
        }

        private ListNode merge(ListNode leftSorted, ListNode rightSorted) {
            if (leftSorted == null) {
                return rightSorted;
            }
            if (rightSorted == null) {
                return leftSorted;
            }
            if (leftSorted.val < rightSorted.val) {
                leftSorted.next = merge(leftSorted.next, rightSorted);
                return leftSorted;
            }
            rightSorted.next = merge(leftSorted, rightSorted.next);
            return rightSorted;
        }
    }
}
