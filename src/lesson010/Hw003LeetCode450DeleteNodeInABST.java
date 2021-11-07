package lesson010;

import general.TreeNode;

public class Hw003LeetCode450DeleteNodeInABST {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) {
                return null;
            }
            if(root.val == key) {
                if(root.left == null && root.right == null) {
                    return null;
                } else {
                    if(root.right != null) {
                        root.val = findReplaceValueByRight(root.right);
                        root.right = deleteNode(root.right, root.val);
                    }  else {
                        root.val = findReplaceValueByLeft(root.left);
                        root.left = deleteNode(root.left, root.val);
                    }
                }
            } else if(key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                root.left = deleteNode(root.left, key);
            }
            return root;
        }

        private int findReplaceValueByRight(TreeNode root) {
            while(root.left != null) {
                root = root.left;
            }
            return root.val;
        }

        private int findReplaceValueByLeft(TreeNode root) {
            while(root.right != null) {
                root = root.right;
            }
            return root.val;
        }

    }

}
