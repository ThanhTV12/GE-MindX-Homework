package lesson008.homework;

import general.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Hw006LeetCode1302DeepestLeavesSum {
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            if(root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            int sum = 0;
            while(!queue.isEmpty()) {
                sum = 0;
                int currentSize = queue.size();
                for(int i = 0; i < currentSize; i++) {
                    TreeNode node = queue.remove();
                    sum += node.val;
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return sum;
        }
    }
}
