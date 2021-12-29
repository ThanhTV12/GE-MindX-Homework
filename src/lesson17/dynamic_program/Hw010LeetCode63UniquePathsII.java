package lesson17.dynamic_program;

public class Hw010LeetCode63UniquePathsII {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = 0;
            if(n > 0) {
                m = obstacleGrid[0].length;
            }
            if(n * m == 0) {
                return 0;
            }
            int[][] ways = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(obstacleGrid[i][j] == 1) {
                        continue;
                    }
                    if(i + j == 0) {
                        ways[i][j] = 1;
                        continue;
                    }
                    int left = 0;
                    if(i > 0) {
                        left = ways[i - 1][j];
                    }
                    int top = 0;
                    if(j > 0) {
                        top = ways[i][j - 1];
                    }

                    ways[i][j] =  left + top;
                }
            }
            return ways[n - 1][m - 1];
        }
    }
}
