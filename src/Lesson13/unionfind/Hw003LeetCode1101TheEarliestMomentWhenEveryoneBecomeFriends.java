package Lesson13.unionfind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hw003LeetCode1101TheEarliestMomentWhenEveryoneBecomeFriends {

    public static void main(String[] args) {
        int[][] logs = new int[][] {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
                int n = 6;
                
        Solution solution = new Solution();
        int i = solution.earliestAcq(logs, n);
    }

    private static class Solution {
        public int earliestAcq(int[][] logs, int n) {
            Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
            parent = new int[n];
            rank = new int[n];
            times = new int[n];
            numerItems = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                numerItems[i] = 1;
            }

            Set<Integer> visisted = new HashSet();
            int res;
            for(int[] log : logs) {
                if(find(log[1]) == find(log[2])) {
                    continue;
                }
                System.out.println("log: " + Arrays.toString(log));
                int numberItem = numerItems[find(log[1])] +  numerItems[find(log[2])];
                if(numberItem == n) {
                    return log[0];
                }
                numerItems[find(log[1])] = numberItem;
                numerItems[find(log[2])] = numberItem;
                union(log[1], log[2]);
            }
            return -1;
        }

        int[] parent;
        int[] rank;
        int[] times;
        int[] numerItems;

        private int find(int x) {
            if(parent[x] == x) {
                return x;
            }
            return find(parent[x]);
        }

        private void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if(rank[rootU] == rank[rootV]) {
                parent[rootV] = rootU;
                rank[rootU] = rank[rootU] + 1;
            } else if(rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
            }
        }
    }
}
