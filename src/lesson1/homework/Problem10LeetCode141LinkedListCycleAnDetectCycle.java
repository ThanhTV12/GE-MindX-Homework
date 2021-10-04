package lesson1.homework;

public class Problem10LeetCode141LinkedListCycleAnDetectCycle {
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
        item4.next = item2;

        Solution solution = new Solution();
        boolean hasCycle = solution.hasCycle(head);
        ListNode cyclePoint = solution.detectCycle(head);
    }

    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) {
                    return true;
                }
            }
            return false;
        }

        public ListNode detectCycle(ListNode head) {
            ListNode meetingPoint = getMeetingPoint(head);
            if(meetingPoint == null) {
                return null;
            }

            // run from head and the meeting point. They will meet each other at the cycle point.
            while (true) {
                if(head == meetingPoint) {
                    return meetingPoint;
                }
                head = head.next;
                meetingPoint = meetingPoint.next;
            }
        }

        private ListNode getMeetingPoint(ListNode head) {
            if(head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) {
                    return slow;
                }
            }
            return null;
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
