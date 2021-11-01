package lesson007.homework;

import general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Hw014LeetCode144BinaryTreePreorderTraversal {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            bfs(root);
            return result;
        }

        List<Integer> result = new ArrayList();
        private void bfs(TreeNode root) {
            if(root == null) {
                return;
            }
            result.add(root.val);
            bfs(root.left);
            bfs(root.right);
        }
    }
}
