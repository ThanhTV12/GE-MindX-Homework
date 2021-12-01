package Lesson13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hw003LeetCode787CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int[][] flights = {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}};
        int src = 6;
        int dst = 0;
        int k = 7;
        int cheapestPrice = solution.findCheapestPrice(n, flights, src, dst, k);
    }

    private static class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // Created a weighted graph
            // Node: (city, most number of stop) => number of nodes = n * k
            // edge: flights => number of edge = flights.length;
            // use Dijkstra to travel from node(src, k + 1) to node(dst, ...) to find the shortest way (cheapest)
            // return value;
            // time complexity = O(lights.length * log(n*k))

            //Step 1 build the graph
            Map<Integer, List<int []>> adjList = new HashMap();
            for(int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList());
            }
            for(int i = 0; i < flights.length; i++) {
                adjList.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
            }

            //
            Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // node(city, most number of stop, price)
            int[][] srcDstPrice = new int[n][k + 2];
            int OUT_OF_PRICE = 100000000;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < k + 2; j++) {
                    srcDstPrice[i][j] = OUT_OF_PRICE;
                }
            }
            // intiate for src node is 0 because we don't need and fight
            srcDstPrice[src][k + 1] = 0;
            int[] srcNode = new int[] {src, k + 1, 0};
            q.add(srcNode);

            while(!q.isEmpty()) {
                int[] u = q.remove();
                int curCity = u[0];
                int curK = u[1];
                int curPrice = u[2];
                if(curK == 0) {
                    continue;
                }
                int nextK = curK - 1;
                if(adjList.containsKey(u[0])) {
                    for(int[] fight : adjList.get(u[0])) {
                        int city = fight[0];
                        int price = fight[1];
                        if(srcDstPrice[city][nextK] >  srcDstPrice[curCity][curK] + price) {
                            srcDstPrice[city][nextK] =  srcDstPrice[curCity][curK] + price;
                            q.add(new int[] {city, nextK, srcDstPrice[city][nextK]});
                        }
                    }
                }
            }
            int[] listPriceToDest = srcDstPrice[dst];
            if(listPriceToDest.length == 0) {
                return -1;
            }
            int res = listPriceToDest[0];
            for(int i = 1; i < listPriceToDest.length; i++) {
                if(res > listPriceToDest[i]) {
                    res = listPriceToDest[i];
                }
            }
            if(res == OUT_OF_PRICE) {
                return -1;
            }
            return res;
        }
    }
}
