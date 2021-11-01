package lesson008.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hw003LeetCode429NaryTreeLevelOrderTraversal {
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            Queue<Node> queue = new LinkedList();
            List<List<Integer>> result = new ArrayList();
            if(root == null) {
                return result;
            }
            queue.add(root);
            while(!queue.isEmpty()) {
                int currentSize = queue.size();
                List<Integer> eleInSameLevel = new ArrayList();
                for(int i = 0; i < currentSize; i++) {
                    Node node = queue.remove();
                    eleInSameLevel.add(node.val);
                    for(Node child : node.children) {
                        queue.add(child);
                    }
                }
                result.add(eleInSameLevel);
            }
            return result;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
