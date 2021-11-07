package lesson010;

import general.TreeNode;

public class Hw002SearchInABinarySearchTree {
    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null) {
                return null;
            }
            if(val == root.val) {
                return root;
            }
            if(val > root.val) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }
        }
    }
}
