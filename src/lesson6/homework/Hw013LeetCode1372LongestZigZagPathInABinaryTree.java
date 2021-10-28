package lesson6.homework;

import general.TreeNode;

public class Hw013LeetCode1372LongestZigZagPathInABinaryTree {
    public static void main(String[] args) {
        //[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
        TreeNode root = new TreeNode();
        root.val = 1;

        Solution solution = new Solution();
        int longestZigZag = solution.longestZigZag(root);

    }

    private static class Solution {
        public int longestZigZag(TreeNode root) {
            dfs(root, 0);
            return mostZigzagNodes;
        }

        int mostZigzagNodes  = 0;
        // previousDirection == 0 root
        // previousDirection == 1 left
        // previousDirection == 2 right
        private int dfs(TreeNode node, int previousDirection) {
            if(node == null) {
                return 0;
            }
            if(node.left == null && node.right == null) {
                return 1;
            }
            int lengthLeftSide = dfs(node.left, 1);
            int lengthRightSide = dfs(node.right, 2);
            if (previousDirection == 1) {
                if(lengthRightSide + 1> mostZigzagNodes) {
                    mostZigzagNodes = lengthRightSide + 1;
                }
                return lengthRightSide + 1;
            }
            if (previousDirection == 2) {
                if(lengthLeftSide + 1> mostZigzagNodes) {
                    mostZigzagNodes = lengthLeftSide + 1;
                }
                return lengthLeftSide + 1;
            }

            return mostZigzagNodes;
        }
    }
}
