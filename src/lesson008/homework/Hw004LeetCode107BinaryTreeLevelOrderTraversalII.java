package lesson008.homework;

import general.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hw004LeetCode107BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        Collections.reverse(new ArrayList<>());
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList();
            List<List<Integer>> levels = new ArrayList();
            if(root == null) {
                return levels;
            }
            queue.add(root);
            while(!queue.isEmpty()) {
                int currentSize = queue.size();
                List<Integer> level = new ArrayList();
                for(int i = 0; i < currentSize; i++) {
                    TreeNode node = queue.remove();
                    level.add(node.val);
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
                levels.add(level);
            }
            Collections.reverse(levels);
            return levels;
        }

    }
}
