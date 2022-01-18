package Lesson22_sercurity.algorithm;

import general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113PathSumII {

    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> init = new ArrayList();
            dfs(root, targetSum, init, 0);
            return results;
        }

        List<List<Integer>> results = new ArrayList();
        void dfs(TreeNode node, int targetSum, List<Integer> list, int sum) {
            if(node == null) {
                return;
            }
            if(node.left == null && node.right == null) {
                if(sum + node.val == targetSum) {
                    List<Integer> result = new ArrayList<>(list);
                    result.add(node.val);
                    results.add(result);
                }
                return;
            }
            List<Integer> copy = new ArrayList<>(list);
            copy.add(node.val);
            sum += node.val;
            if(node.left != null) {
                dfs(node.left, targetSum, copy, sum);
            }
            if(node.right != null) {
                dfs(node.right, targetSum, copy, sum);
            }
        }
    }
}
