package lesson010;

import general.TreeNode;

public class Hw005LeetCode669TrimABinarySearchTree {
    public static void main(String[] args) {
        //[3,0,4,null,2,null,null,1]
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        TreeNode treeNode = solution.trimBST(root, 1, 3);
    }

    private static class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) return root;
            //if (root.val > high) return trimBST(root.left, low, high);
            TreeNode subTree = root;
            if (root.val < low) {
                subTree = trimBST(root.right, low, high);
                return subTree;
            };
            if (subTree.val > high) {
                subTree = trimBST(root.left, low, high);
                return subTree;
            };
            subTree.left = trimBST(root.left, low, high);
            subTree.right = trimBST(root.right, low, high);
            return subTree;
        }
    }
}
