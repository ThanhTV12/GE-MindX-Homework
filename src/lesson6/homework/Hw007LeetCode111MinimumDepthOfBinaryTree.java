package lesson6.homework;

import general.TreeNode;

public class Hw007LeetCode111MinimumDepthOfBinaryTree {
    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int minDepthByLeft = minDepth(root.left);
            int minDepthByRight = minDepth(root.right);
            if(minDepthByLeft == 0) {
                return minDepthByRight + 1;
            }
            if(minDepthByRight == 0) {
                return minDepthByLeft + 1;
            }
            return Math.min(minDepthByLeft, minDepthByRight) + 1;
        }
    }
}
