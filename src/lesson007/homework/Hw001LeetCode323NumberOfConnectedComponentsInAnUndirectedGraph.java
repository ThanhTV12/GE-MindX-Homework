package lesson007.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hw001LeetCode323NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countComponents(5, new int[][] {{0,1},{1,2},{0,2},{3,4}});
    }
    private static class Solution {
        public int countComponents(int n, int[][] edges) {
            isConnected = new boolean[n];
            Map<Integer, List<Integer>> adjList = new HashMap();
            for(int i = 0; i < edges.length; i++) {
                if(adjList.containsKey(edges[i][0])) {
                    adjList.get(edges[i][0]).add(edges[i][1]);
                } else {
                    List<Integer> adj = new ArrayList();
                    adj.add(edges[i][1]);
                    adjList.put(edges[i][0], adj);
                }
                if(adjList.containsKey(edges[i][1])) {
                    adjList.get(edges[i][1]).add(edges[i][0]);
                } else {
                    List<Integer> adj = new ArrayList();
                    adj.add(edges[i][0]);
                    adjList.put(edges[i][1], adj);
                }
            }
            int connectedComponents = 0;
            for(int i = 0; i < n; i++) {
                if(isConnected[i] == true) {
                    continue;
                }
                connectedComponents++;
                dfs(adjList, i);
            }
            return connectedComponents;
        }


        boolean[] isConnected;
        private void dfs(Map<Integer, List<Integer>> adjList, int node) {
            if(isConnected[node] == true) {
                return;
            }
            isConnected[node] = true;
            if(!adjList.containsKey(node)) {
                return;
            }
            for(Integer item : adjList.get(node)) {
                dfs(adjList, item);
            }
        }
    }
}
