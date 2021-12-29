package lesson17.dynamic_program;

public class Hw010LeetCode62UniquePaths {
    //DP
// Step 1: define state => uPs[i][j] the number of paths Which we can reach the postion i, j from start
// Step 2: find the relationship between problem and subproblem => uPs[i][j] = uPs[i - 1][j] + uPs[i][j - 1];
// Step 3: Base cases => uPs[0][0] = 0;
// return uPs[m - 1][n - 1]
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] uPs = new int[m][n];
            uPs[0][0] = 1;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(i + j == 0) {
                        continue;
                    }
                    int top = 0; //uPs[i - 1][j]
                    if(i - 1 >= 0) {
                        top = uPs[i - 1][j];
                    }
                    int left = 0; //uPs[i][j - 1]
                    if(j - 1 >= 0) {
                        left = uPs[i][j - 1];
                    }
                    uPs[i][j] = top + left;
                }
            }
            return uPs[m - 1][n - 1];
        }
    }
}
