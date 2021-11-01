package lesson007.homework;

import general.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class Hw002LeetCode547NumberOfProvinces {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
        int circleNum = solution.findCircleNum(isConnected);
    }

    private static class Solution {
        public int findCircleNum(int[][] isConnected) {
            List<List<Integer>> provincesAdjList = transformToGraph(isConnected);
            AdjListGraph providesGraph = new AdjListGraph(provincesAdjList);
            return providesGraph.countTheNumberOfComponents();
        }

        private List<List<Integer>> transformToGraph(int[][] isConnected) {
            List<List<Integer>> cityGraph = new ArrayList();
            for(int i = 0; i < isConnected.length; i++) {
                int[] row = isConnected[i];
                List<Integer> adjacencyListOfCities = new ArrayList();
                for(int j = 0; j < row.length; j++) {
                    if(row[j] == 1) {
                        adjacencyListOfCities.add(j);
                    }
                }
                cityGraph.add(adjacencyListOfCities);
            }
            return cityGraph;
        }
    }
}
