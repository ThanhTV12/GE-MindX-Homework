package lesson6.homework;

import general.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hw009LeetCode508MostFrequentSubtreeSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 5;
        TreeNode left = new TreeNode();
        left.val = 2;
        TreeNode right = new TreeNode();
        right.val = -3;
        root.left = left;
        root.right = right;

        Solution solution = new Solution();
        int[] frequentTreeSum = solution.findFrequentTreeSum(root);
    }

    private static class Solution {
        public int[] findFrequentTreeSum(TreeNode root) {
            dfs(root);
            List<Integer> listOfHighestFrequencySum = new ArrayList();
            int[] result = new int[frequencySum.size()];
            int index = 0;
            for(Integer sum : frequencySum.keySet()) {
                if(frequencySum.get(sum) == highestfrequency) {
                    result[index++] = sum;
                }
            }
            return Arrays.copyOf(result, index);
        }

        int highestfrequency = 1;
        Map<Integer, Integer> frequencySum = new HashMap();
        private int dfs(TreeNode node) {
            if(node == null) {
                return 0;
            }
            int subTreeSum = dfs(node.left) + dfs(node.right) + node.val;
            if(frequencySum.containsKey(subTreeSum)) {
                frequencySum.put(subTreeSum, frequencySum.get(subTreeSum) + 1);
                if(frequencySum.get(subTreeSum) > highestfrequency) {
                    highestfrequency = frequencySum.get(subTreeSum);
                }
            } else {
                frequencySum.put(subTreeSum, 1);
            }
            return subTreeSum;
        }
    }
}
