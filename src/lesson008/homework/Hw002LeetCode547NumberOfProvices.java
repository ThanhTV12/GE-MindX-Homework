package lesson008.homework;

import java.util.LinkedList;
import java.util.Queue;

public class Hw002LeetCode547NumberOfProvices {

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        Solution solution = new Solution();
        int circleNum = solution.findCircleNum(isConnected);
    }

    private static class Solution {

        public int findCircleNum(int[][] isConnected) {
            numerOfNodes = isConnected.length;
            isVisited = new boolean[numerOfNodes];
            int numberOfProvinces = 0;
            for(int i = 0; i  < numerOfNodes; i++) {
                if(isVisited[i] == false) {
                    numberOfProvinces++;
                    bfs(isConnected, i);
                }
            }
            return numberOfProvinces;
        }


        int numerOfNodes = 0;
        boolean[] isVisited;
        Queue<Integer> queue = new LinkedList();

        void bfs(int[][] isConnected, int root) {
            queue.add(root);
            while(!queue.isEmpty()) {
                int node = queue.remove();
                isVisited[node] = true;
                int[] connectedNodes = isConnected[node];
                for(int i = 0; i < connectedNodes.length; i++) {;
                    if(isConnected[node][i] == 1 && isVisited[i] == false) {
                        queue.add(i);
                    }
                }
            }
        }
    }
}
