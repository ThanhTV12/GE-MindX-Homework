package Lesson13;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hw001LeetCode743NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = new int[][] {{1,2,1},{2,1,3}};
        int n = 2, k = 2;
        int i = solution.networkDelayTime(times, n, k);
    }


    private static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, List<int[]>> adjList = new HashMap(); //List<int[]> u and w
            //put network into adjList
            for(int i = 1; i < n + 1; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for(int i = 0; i < times.length; i++) {
                adjList.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
            }
            //Dijkstra
            Queue<int[]> q = new PriorityQueue<>((a , b) -> Integer.compare(a[0], b[0]));
            int[] d = new int[n + 1];
            int OUT_OF_VALUE = 1000;
            for(int i = 1; i < n + 1; i++) {
                d[i] = OUT_OF_VALUE;
            }
            d[k] = 0;
            q.add(new int[]{0, k});
            while(!q.isEmpty()) {
                int u = q.remove()[1];
                for(int[] vw : adjList.get(u)) {
                    int v = vw[0];
                    int w = vw[1];
                    if(d[v] > d[u] + w) {
                        d[v] = d[u] + w;
                        q.add(new int[]{d[v], v});
                    }
                }
            }
            int res = 0;
            for(int i = 0; i < d.length; i++) {
                if(d[i] == OUT_OF_VALUE) {
                    return -1;
                }
                if(d[i] > res) {
                    res = d[i];
                }
            }
            return res;
        }
    }
}
