package lesson17.dynamic_program;

public class Hw0012LeetCode64MinimumPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            int n = grid.length;
            int m = 0;
            if(n > 0) {
                m = grid[0].length;
            }
            if(n * m == 0) {
                return 0;
            }
            int[][] pathSum = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(i + j == 0) {
                        pathSum[i][j] = grid[i][j];
                        continue;
                    }
                    int left = Integer.MAX_VALUE;
                    if(j > 0) {
                        left = pathSum[i][j - 1];
                    }
                    int top = Integer.MAX_VALUE;
                    if(i > 0) {
                        top = pathSum[i - 1][j];
                    }

                    pathSum[i][j] = Math.min(left, top) + grid[i][j];
                    //stem.out.println("i: " + i + " - j:" + j + " - sum:" + pathSum[i][j] );
                }
            }
            return pathSum[n - 1][m - 1];
        }
    }
}
