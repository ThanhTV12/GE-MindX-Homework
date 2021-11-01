package lesson007.homework;

import general.TreeNode;

public class Hw012LeetCode687LongestUnivaluePath {
    class ContinuousSameNode {
        public int value;
        public int count;
        public ContinuousSameNode(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    class Solution {
        public int longestUnivaluePath(TreeNode root) {
            dfsUnivaluePath(root);
            return maxTotalNodes;
        }

        int maxTotalNodes = 0;
        private ContinuousSameNode dfsUnivaluePath(TreeNode node) {
            if(node == null) {
                return null;
            }
            if(node.left == null && node.right == null) {
                return new ContinuousSameNode(node.val, 1);
            }
            ContinuousSameNode left = dfsUnivaluePath(node.left);
            ContinuousSameNode right = dfsUnivaluePath(node.right);
            int value = node.val;
            int countNodeLeft = 0;
            int countNodeRight = 0;
            if(left != null && left.value == value) {
                countNodeLeft = left.count;
            }
            if(right != null && right.value == value) {
                countNodeRight = right.count;
            }
            if(countNodeLeft + countNodeRight > maxTotalNodes) {
                maxTotalNodes = countNodeLeft + countNodeRight;
            }
            if(countNodeLeft > countNodeRight) {
                return new ContinuousSameNode(value, countNodeLeft + 1);
            }
            return new ContinuousSameNode(value, countNodeRight + 1);
        }
    }
}
