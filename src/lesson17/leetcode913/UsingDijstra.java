package lesson17.leetcode913;

import java.util.PriorityQueue;
import java.util.Queue;

public class UsingDijstra {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{2,1,3},
                                    {6,5,4},
                                    {7,8,9}};
        int value = new Solution().minFallingPathSum(matrix);
        System.out.println(value);
    }

    // Solution 2
// Use Dijstra
// Step 2: iterate through all element on the first row, use Dijstra to go to the last row => push minnim sum when travel to  specified position by  minnim array
// Step 3: on minSum array find min value at the last row
//

    static class Solution {
        int n; // the number of row
        int m; // the number of col
        public int minFallingPathSum(int[][] matrix) {
            n = matrix.length;
            if(n == 0) {
                return 0;
            }
            m = matrix[0].length;
            intD();
            for(int i = 0; i < m; i++) {
                dijstra(0, i, matrix);
            }
            int res = d[n - 1][0];
            for(int j = 1; j < m; j++) {
                if(res > d[n - 1][j]) {
                    res = d[n - 1][j];
                }
            }
            return res;
        }

        // dijstra
        int[][] d;
        Queue<Node> heap;

        private void intD() {
            d = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] DR = new int[] {1, 1, 1};
        int[] DC = new int[] {-1, 0, 1};

        private void dijstra(int r, int c, int[][] matrix) {
            heap = new PriorityQueue<>((a, b) -> Integer.compare(a.sum, b.sum));
            //Push the source into heap
            heap.add(new Node(r, c, matrix[r][c]));
            d[r][c] = matrix[r][c];
            while(!heap.isEmpty()) {
                Node u = heap.remove();
                //load all nodes connected with u
                for(int i = 0; i < 3; i++) {
                    int nR = u.r + DR[i];
                    int nC = u.c + DC[i];
                    if(nR < 0 || nR == n) {
                        continue;
                    }
                    if(nC < 0 || nC == m) {
                        continue;
                    }
                    if(d[nR][nC] > u.sum + matrix[nR][nC]) {
                        //relaxtion
                        d[nR][nC] = u.sum + matrix[nR][nC];
                        heap.add(new Node(nR, nC,  d[nR][nC]));
                    }
                }
            }
        }

    }


    static class Node {
        public int r;
        public int c;
        public int sum;
        public Node(int r, int c, int sum) {
            this.r = r;
            this.c = c;
            this.sum = sum;
        }
    }
}
