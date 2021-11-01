package lesson007.homework;

import general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Hw008LeetCode104MaximumDepthOfBinaryTree {
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int maxDepthLeftSide = maxDepth(root.left);
            int maxDepthRightSide = maxDepth(root.right);
            return Math.max(maxDepthLeftSide, maxDepthRightSide) + 1;
        }
    }
}
