package lesson6.homework;


import general.TreeNode;

public class Hw006LeetCode04SumOfLeftLeaves {
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return sumOfLeftLeaves(root, false);
        }


        /*
         *  depth first search and dynamic program
         *  time complexity O(n)
         *  space complexity O(log(n))
         */
        private int sumOfLeftLeaves(TreeNode node, boolean isLeftOfParent) {
            if(node == null) {
                return 0;
            }
            if(node.left == null && node.right == null) {
                if(isLeftOfParent == true) {
                    return node.val;
                }
                return 0;
            }
            return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
        }
    }
}
