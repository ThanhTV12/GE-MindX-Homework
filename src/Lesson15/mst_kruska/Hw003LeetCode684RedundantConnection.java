package Lesson15.mst_kruska;

public class Hw003LeetCode684RedundantConnection {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = new int[][] {{1,2},{1,3},{2,3}};
        int[] redundantConnection = solution.findRedundantConnection(edges);
    }

    private static class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            //initiate DisjointSet Union - Find
            for(int i = 0; i < 1001; i++) {
                parents[i] = i;
            }
            for(int[] edge : edges) {
                int rootU = find(edge[0]);
                int rootV = find(edge[1]);
                if(rootU == rootV) {
                    return edge;
                }
                union(rootU, rootV);
                //System.out.println(parents);
            }
            return new int[]{0, 0};
        }


        int[] parents = new int[1001];
        int[] ranks = new int[1001];
        //Union - find
        private int find(int item) {
            if(parents[item] == item) {
                return item;
            }
            int parent = parents[item];
            int root = find(parent);
            parents[parent] = root; //path compression
            return root;
        }

        private void union(int rootU, int rootV) {
            int rankU = ranks[rootU];
            int rankV = ranks[rootV];
            if(rankU == rankV) {
                parents[rootV] = rootU;
                ranks[rootU] = ranks[rootU] + 1;
            } else if(rankU > rankV) {
                parents[rootV] = rootU;
            } else {
                parents[rootU] = rootV;
            }
        }
    }
}
