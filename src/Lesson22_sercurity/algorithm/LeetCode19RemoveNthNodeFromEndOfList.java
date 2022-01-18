package Lesson22_sercurity.algorithm;

import general.ListNode;

public class LeetCode19RemoveNthNodeFromEndOfList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            DfsRs rs = dfs(head, n);
            return rs.item;
        }

        private DfsRs dfs(ListNode node, int n) {
            if(node == null) {
                return new DfsRs(null, 0);
            }
            DfsRs rs = dfs(node.next, n);
            int position = rs.position + 1;
            if(rs.position == n - 1) {
                return new DfsRs(rs.item, position);
            } else {
                node.next = rs.item;
            }
            return new DfsRs(node, position);
        }
    }

    class DfsRs {
        public ListNode item;
        public int position;
        public DfsRs(ListNode item, int position) {
            this.item = item;
            this.position = position;
        }
    }


}
