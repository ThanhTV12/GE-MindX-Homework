package Lesson15.mst_kruska;

import java.util.Arrays;

public class Hw002LeetCode1168OptimizeWaterDistributionInaVillage {
    class Solution {


        // Convert from find cost with wells and pipes become a problem, which just find by pipes
        // Step 1: Create a virtual house (contains a well), cost to build wells instead of pipes to this virtual house
        // => houses: n + 1
        // => pipes: length of pipes + n
        // Step 2: Use minimum spanning tree - krusha to find the the minimum total cost to connect all houses including the virtual house

        // Use minimum spanning tree - krusha Argorithm
        // Step 1 Sort all pipes in descreasing of cost
        // Step 2 Use Disjoint set - Union Find to connect 2 house
        // Stop if there are (length of houses - 1) connecton
        // Return result

        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            int[][] newPipes = buildNewPipesIncludingVirtualHouse(n, wells, pipes);
            return findMinCost(newPipes, n + 1);

        }

        //Step 1
        int VIRTUAL_HOUSE = 0;
        private int[][] buildNewPipesIncludingVirtualHouse(int n, int[] wells, int[][] pipes) {
            int[][] newPipes = new int[pipes.length + n][3];
            for(int i = 0; i < pipes.length; i++) {
                newPipes[i] = pipes[i];
            }
            int index = pipes.length;
            for(int i = 0; i < wells.length; i++) {
                newPipes[index++] = new int[]{i + 1, VIRTUAL_HOUSE, wells[i]};
            }
            return newPipes;
        }


        // Step 2
        private int findMinCost(int[][] newPipes, int numberOfElement) {

            //Sort all newPipes in descreasing order of cost
            Arrays.sort(newPipes, (a, b) -> Integer.compare(a[2], b[2]));
            initUnionFind(numberOfElement);
            int totalCost = 0;
            int edges = 0;
            for(int[] newPipe : newPipes) {
                int first = newPipe[0];
                int second = newPipe[1];
                int cost = newPipe[2];

                int rootOfFirst = find(first);
                int rootOfSecond = find(second);
                if(rootOfFirst == rootOfSecond) { // is connected directly or indirectly
                    continue;
                }
                union(rootOfFirst, rootOfSecond);
                totalCost += cost;
                edges++;
                if(edges == numberOfElement - 1) {
                    return totalCost;
                }
            }
            return -1;
        }




        //Disjoin set -union find
        int[] parents;
        int[] ranks;

        private void initUnionFind(int numberOfElement) {
            parents = new int[numberOfElement];
            ranks = new int[numberOfElement];
            for(int i  = 0; i < numberOfElement; i++) {
                parents[i] = i;
            }
        }

        private int find(int house) {
            if(house == parents[house]) {
                return house;
            }
            parents[house] = find(parents[house]);
            return parents[house];
        }

        private void union(int rootU, int rootV) {
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
