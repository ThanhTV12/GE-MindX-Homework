package lesson007.homework;

import general.TreeNode;

public class Hw010LeetoCode543DiameterOfBinaryTree {
    public static void main(String[] args) {

    }


    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            dfsOfdiameter(root);
            return diameter;
        }
        int diameter = 0;
        private int dfsOfdiameter(TreeNode node) {
            if(node.left == null && node.right == null) {
                return 0;
            }
            int lengthOfLeftSide = 0;
            if(node.left != null) {
                lengthOfLeftSide = dfsOfdiameter(node.left) + 1;
            }
            int lengthOfTreeRightSide = 0;
            if(node.right != null) {
                lengthOfTreeRightSide = dfsOfdiameter(node.right) + 1;
            }
            int localDiameter = lengthOfLeftSide + lengthOfTreeRightSide;
            if(localDiameter > diameter) {
                diameter = localDiameter;
            }
            return Math.max(lengthOfLeftSide, lengthOfTreeRightSide);
        }
    }
}
