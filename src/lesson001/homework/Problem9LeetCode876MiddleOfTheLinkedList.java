package lesson001.homework;

public class Problem9LeetCode876MiddleOfTheLinkedList {
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

        Solution solution = new Solution();
        ListNode middle = solution.middleNode(head);
    }

    private static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fastPointer = head;
            ListNode slowPointer = head;
            while (fastPointer.next != null && fastPointer.next.next != null) {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
            if(fastPointer.next != null) {
                return slowPointer.next;
            }
            return slowPointer;
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
