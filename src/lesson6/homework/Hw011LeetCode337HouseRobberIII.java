package lesson6.homework;

import general.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Hw011LeetCode337HouseRobberIII {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode();
        root.val = 3;

        TreeNode left1 = new TreeNode();
        left1.val = 2;

        TreeNode left1Right2 = new TreeNode();
        left1Right2.val = 3;

        root.left = left1;
        left1.right = left1Right2;

        TreeNode right1 = new TreeNode();
        right1.val = 3;

        TreeNode right2 = new TreeNode();
        right2.val = 1;

        root.right = right1;
        right1.right = right2;

        int max = solution.rob(root);
    }

    private static class Solution {
        public int rob(TreeNode root) {
            int robRoot = dfs(root, true);
            int notRobRoot = dfs(root, false);
            return Math.max(robRoot, notRobRoot);
        }

        Map<TreeNode, Integer> robCache_ = new HashMap<>();
        Map<TreeNode, Integer> unRobCache_ = new HashMap<>();

        private void cache(TreeNode node, boolean isRob, int mount) {
            if(isRob == true) {
                robCache_.put(node, mount);
                return;
            }
            unRobCache_.put(node, mount);
        }

        private Integer getCache(TreeNode node, boolean isRob) {
            if(isRob == true && robCache_.containsKey(node)) {
                return robCache_.get(node);
            }
            if(isRob == false && unRobCache_.containsKey(node)) {
                return unRobCache_.get(node);
            }
            return null;
        }

        private int dfs(TreeNode node, boolean isRob) {
            if(node == null) {
                return 0;
            }
            if(getCache(node, isRob) != null) {
                return getCache(node, isRob);
            }
            int mount = 0;
            if(isRob) {
                mount = dfs(node.left, false) + dfs(node.right, false) + node.val;
            } else {
                int mountIfNNotRobU1 = dfs(node.left, true) + dfs(node.right, true);
                int mountIfNNotRobU2 = dfs(node.left, true) + dfs(node.right, false);
                int mountIfNNotRobU3 = dfs(node.left, false) + dfs(node.right, true);
                int mountIfNNotRobU4 = dfs(node.left, false) + dfs(node.right, false);
                int[] values = new int[]{mountIfNNotRobU1, mountIfNNotRobU2, mountIfNNotRobU3, mountIfNNotRobU4};
                mount = getMax(values);
            }
            cache(node, isRob, mount);
            return mount;
        }

        private int getMax(int[] values) {
            int max = values[0];
            for(int i = 1; i < values.length; i++) {
                if(max < values[i]) {
                    max = values[i];
                }
            }
            return max;
        }
    }
}
