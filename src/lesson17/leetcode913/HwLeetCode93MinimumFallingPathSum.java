package lesson17.leetcode913;

public class HwLeetCode93MinimumFallingPathSum {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,1,3},
                                    {6,5,4},
                                    {7,8,9}};
        Solution solution = new Solution();
        solution.minFallingPathSum(matrix);
    }

    // DP
    // Step 1: defind state => minSum[i][j] the munimum sum which we ca reach at i, j
    // Step 2: find relationship between problem and it's subproblem => minSum[i][j] = min(minSum[i - 1, j - 1], minSum[i - 1, j], minSum[i - 1, j + 1])
    // Step 3: base case:  minSum[0][j] = matrix[0][j]
    static class Solution {
        int OUT_OF_VALUE = Integer.MAX_VALUE;

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            if (n == 0) {
                return 0;
            }
            int m = matrix[0].length;
            int[][] minSum = new int[n][m];
            //intiate base cases
             for(int j = 0; j < m; j++) {
                 minSum[0][j] = matrix[0][j];
             }

            //Step 2
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int previousTopLeft = OUT_OF_VALUE;
                    if (j - 1 >= 0) {
                        previousTopLeft = minSum[i - 1][j - 1];
                    }
                    int previousTop = minSum[i - 1][j];
                    int previousTopRight = OUT_OF_VALUE;
                    if (j + 1 < m) {
                        previousTopRight = minSum[i - 1][j + 1];
                    }
                    minSum[i][j] = Math.min(Math.min(previousTopLeft, previousTop), previousTopRight) + matrix[i][j];
                }
            }
            // find minimun value in the araay minSum[n-1]
            int res = minSum[n - 1][0];
            for (int j = 1; j < m; j++) {
                if (res > minSum[n - 1][j]) {
                    res = minSum[n - 1][j];
                }
            }
            return res;
        }
    }
}
