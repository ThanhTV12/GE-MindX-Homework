package lesson6.homework;

import general.GripGraph;

public class Hw004LeetCode200NumberOfIslands {


    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Solution solution = new Solution();
        int numIslands = solution.numIslands(grid);
    }


    private static class Solution {

        public int numIslands(char[][] grid) {
            GripGraph gripGraph = new GripGraph(grid);
            /*
             *  the number of islands is the number of connected components
             */
            int numberOfIslands = gripGraph.findNumberOfConnectedComponents();
            return numberOfIslands;
        }
    }
}
