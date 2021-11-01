package lesson008.homework;

import general.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hw005LeetCode199BinaryTreeRightSideView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            bfs(root);
            return valuesRightSide;
        }

        List<Integer> valuesRightSide = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        private void bfs(TreeNode root) {
            if(root == null) {
                return;
            }
            queue.add(root);
            while(!queue.isEmpty()) {
                int currentSize = queue.size();
                for(int i = 0; i < currentSize; i++) {
                    TreeNode node = queue.remove();
                    if(currentSize - 1 == i) {
                        valuesRightSide.add(node.val);
                    }
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
    }
}
