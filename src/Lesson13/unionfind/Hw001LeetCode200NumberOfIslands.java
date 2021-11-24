package Lesson13.unionfind;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hw001LeetCode200NumberOfIslands {
    //Union Find
//Step 1
//create parent array and rank array to present Tree(union)
//originally the island's parent is itselft

//Step 2 find - union (merge)
//if contains ways to travel from this land to that land, union them


//Step 3
// total of islands is number of trees


    public static void main(String[] args) {
        char[][] grid = new char[][]
                {{'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};

        Solution solution = new Solution();
        int i = solution.numIslands(grid);
    }

    private static class Solution {

        Land[][] parent;
        int[][] rank;
        int m;
        int n;

        public int numIslands(char[][] grid) {
            //Step1
            m = grid.length;
            if(m == 0) {
                return 0;
            }
            n = grid[0].length;
            if(n == 0) {
                return 0;
            }
            parent = new Land[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        parent[i][j] = new Land(i, j);
                    }
                }
            }
            rank = new int[m][n];
            isVisited = new boolean[m][n];

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1' && isVisited[i][j] == false) {
                        isVisited[i][j] = true;
                        unionNeighbours(new Land(i, j), grid);
                    }
                }
            }
            Set<Land> setOfParent = new HashSet<>();
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(parent[i][j] != null) {
                        setOfParent.add(parent[i][j]);
                    }
                }
            }
            return setOfParent.size();
        }

        boolean[][] isVisited;
        int[] DR = {1, 0, -1, 0};
        int[] DC = {0, 1, 0, -1};
        private void unionNeighbours(Land land, char[][] grid) {
            for(int i = 0; i < 4; i++) {
                int nbRow = land.row + DR[i];
                int nbCol = land.col + DC[i];
                if(nbRow < 0 || nbRow == m || nbCol < 0 || nbCol == n) {
                    continue;
                }
                if(isVisited[nbRow][nbCol] == true) {
                    continue;
                }
                if(grid[nbRow][nbCol] == '1') {
                    isVisited[nbRow][nbCol] = true;
                    Land nb = new Land(nbRow, nbCol);
                    union(land, nb);
                    unionNeighbours(nb, grid);
                }
            }
        }

        private Land findParent(Land land) {
            if(land == parent[land.row][land.col]) {
                return land;
            }
            return findParent(parent[land.row][land.col]);
        }

        private void union(Land u, Land v) {
            Land rootU = findParent(u);
            Land rootV = findParent(v);
            if(rootU == rootV) {
                return;
            }
            int rankU = rank[rootU.row][rootU.col];
            int rankV = rank[rootV.row][rootV.col];
            if(rankU == rankV) {
                parent[rootV.row][rootV.col] = rootU;
                rank[rootU.row][rootU.col] = rank[rootU.row][rootU.col] + 1;
            } else if(rankU < rankV) {
                parent[rootU.row][rootU.col] = rootV;
            } else {
                parent[rootV.row][rootV.col] = rootU;
            }
        }
    }

    private static class Land {
        public int row;
        public int col;

        public Land(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Land land = (Land) o;
            return row == land.row && col == land.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
