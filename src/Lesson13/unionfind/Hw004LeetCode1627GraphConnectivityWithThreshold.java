package Lesson13.unionfind;

import java.util.ArrayList;
import java.util.List;

public class Hw004LeetCode1627GraphConnectivityWithThreshold {

    public static void main(String[] args) {
        int n = 15;
        int threshold = 2;
        int[][] queries = new int[][] {{1,4},{2,5},{3,6}, {4, 15}};
        Solution solution = new Solution();
        List<Boolean> booleans = solution.areConnected(n, threshold, queries);
    }


    private static class Solution {

        // build Union find
        // Build union for directly connected cities ()
        // if there is some value betweeen 2 groups, they was connected automaticly and inderectly
        // Find


        public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
            parents = new int[n + 1];
            ranks = new int[n + 1];
            buildGraph(n, threshold);
            List<Boolean> res = new ArrayList();
            for(int i = 0; i < queries.length; i++) {
                int rootOfFirst = find(queries[i][0]);
                int rootOfSecond = find(queries[i][0]);
                res.add(rootOfFirst == rootOfSecond);
            }
            return res;
        }

        int[] parents;
        int[] ranks;

        private void buildGraph(int n, int threshold) {
            for(int i = 1; i < n + 1; i++) {
                parents[i] = i;
            }
            for(int u = threshold + 1; u < n + 1; u++) {
                for(int v = u * 2; v < n + 1; v = v + u) {
                    union(u, v);
                }
            }
        }

        private int find(int e) {
            if(e == parents[e]) {
                return e;
            }
            parents[e] = find(parents[e]);
            return parents[e];
        }

        private void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if(rootU == rootV) {
                return;
            }
            if(ranks[rootU] == ranks[rootV]) {
                parents[rootV] = rootU;
                ranks[rootU] = ranks[rootU] + 1;
            } else if(ranks[rootU] > ranks[rootV]) {
                parents[rootV] = rootU;
            } else {
                parents[rootU] = rootV;
            }
        }
    }
}
