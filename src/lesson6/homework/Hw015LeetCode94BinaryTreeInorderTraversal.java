package lesson6.homework;

import general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Hw015LeetCode94BinaryTreeInorderTraversal {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            return bfs(root);
        }
        private List<Integer> bfs(TreeNode root) {
            if(root == null) {
                return new ArrayList();
            }
            List<Integer> resultLocall = new ArrayList();
            List<Integer> left = bfs(root.left);
            List<Integer> right = bfs(root.right);
            resultLocall.addAll(left);
            resultLocall.add(root.val);
            resultLocall.addAll(right);
            return resultLocall;
        }
    }
}
