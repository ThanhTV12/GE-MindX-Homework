package Lesson15.mst_kruska;

import java.util.Arrays;

//https://leetcode.com/problems/connecting-cities-with-minimum-cost/
public class Hw001LeetCode1135ConnectingCitiesWithMinimumCost {

    public static void main(String[] args) {

    }

    class Solution {

        //minimum spanning tree - Kushka

        // Step 1: Sort all connections in descreasing order of cost
        // Step 2: interate all connections, connect 2 cities if 2 cities were not connected
        // Stop if there are n - 1 edges (all the cities were connected)
        // Step 3: return value

        //Make Disjoint set - Union Find to connect 2 cities

        public int minimumCost(int n, int[][] connections) {
            //Step 1
            Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));

            //Step 2
            int res = 0;
            int edges = 0;
            // intiate parents and ranks for Union find
            parents = new int[n + 1];
            ranks = new int[n + 1];
            for(int i = 1; i < n + 1; i++) {
                parents[i] = i;
            }

            for(int[] connection : connections) {

                int first = connection[0];
                int second = connection[1];
                int cost = connection[2];
                int rootOfRirst = find(first);
                int rootOfSecond = find(second);
                if(rootOfRirst == rootOfSecond) {
                    continue;
                }
                union(rootOfRirst, rootOfSecond);
                res += cost;
                edges++;
                if(edges == n - 1) {
                    return res;
                }
            }
            return -1;
        }


        int[] parents;
        int[] ranks;

        private int find(int city) {    //find Root
            if(city == parents[city]) {
                return city;
            }
            parents[city] = find(parents[city]);
            return parents[city];
        }

        private void union(int rootU, int rootV) {
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
