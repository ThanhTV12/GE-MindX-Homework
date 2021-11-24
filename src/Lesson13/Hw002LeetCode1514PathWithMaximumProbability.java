package Lesson13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hw002LeetCode1514PathWithMaximumProbability {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] edges = new int[][]{{0,1}};
        double[] succProb = new double[] {0.5};
        int start = 0, end = 2;
        double v = solution.maxProbability(n, edges, succProb, start, end);
    }

    private static class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            //put into adjList
            //use map heap
            //Dijkstra use heap to travel from start to end
            // when meet the end return
            //Step 1 - create graph
            Map<Integer, List<double[]>> adjList = new HashMap<>();
            for(int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList<>());
            }

            for(int i = 0; i < edges.length; i++) {
                adjList.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
                adjList.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
            }
            //Step 2 - Dijkstra
            Queue<double[]> q = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
            double[] d = new double[n];
            d[start] = 1;

            q.add(new double[]{1.0, start});
            while(!q.isEmpty()) {
                int s = (int) q.remove()[1];
                for(double[] probAndDest : adjList.get(s)) {
                    int dest = (int)probAndDest[0];
                    if(d[dest] < d[s] * probAndDest[1]) {// dest[1] is the lable and dest[0] is probability
                        d[dest] = d[s] * probAndDest[1];
                        q.add(new double[]{d[dest], dest});
                    }
                }
            }
            return d[end];
        }
    }
}
