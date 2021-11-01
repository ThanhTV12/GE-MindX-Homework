package lesson007.homework;

public class Hw005LeetCode695MaxAreaOfIsland {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int max = solution.maxAreaOfIsland(grid);
    }

    private static class Solution {

        boolean[][] visited;
        int rowLength = 0;
        int colLength = 0;
        public int maxAreaOfIsland(int[][] grid) {
            rowLength = grid.length;
            if(rowLength != 0) {
                colLength = grid[0].length;
            }
            visited = new boolean[rowLength][colLength];
            Integer maximumArea = 0;
            for(int i = 0; i < rowLength; i++) {
                for(int j = 0; j < colLength; j++) {
                    if(grid[i][j] == 0) {
                        continue;
                    }
                    int numerOfArea = findNumberOfArea(grid, i, j);
                    if(numerOfArea > maximumArea) {
                        maximumArea = numerOfArea;
                    }
                }
            }
            return maximumArea;
        }

        Integer numerOfArea = 0;
        private int findNumberOfArea(int[][] grid,  int r, int c) {
            numerOfArea = 0;
            dfs(grid, r, c);
            return numerOfArea;
        }

        int[] DR = new int[] {1, 0, -1, 0};
        int[] DC = new int[] {0, 1, 0, -1};
        private void dfs(int[][] grid, int r, int c) {
            if(visited[r][c]) {
                return;
            }
            visited[r][c] = true;
            numerOfArea++;
            for(int i = 0; i < 4; i++) {
                int neighbourR = r + DR[i];
                int neighbourC = c + DC[i];
                if(neighbourR >= 0 && neighbourR < rowLength
                        && neighbourC >= 0 && neighbourC < colLength
                        && grid[neighbourR][neighbourC] == 1) {
                    dfs(grid, neighbourR, neighbourC);
                }
            }
        }
    }
}
