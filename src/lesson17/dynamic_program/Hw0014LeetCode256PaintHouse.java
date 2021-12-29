package lesson17.dynamic_program;

public class Hw0014LeetCode256PaintHouse {
    //int[i][j] totalCost // the minimim cost to paint all house at i-th house for each color 0 <= j < 3
    class Solution {
        public int minCost(int[][] costs) {
            int n = costs.length; // the number of houses
            int[][] totalCosts = new int[n][3];
            //base case
            totalCosts[0] = costs[0];
            for(int i = 1; i < n; i++) {
                for(int k = 0; k < 3; k++) {
                    totalCosts[i][k] = Integer.MAX_VALUE;
                    for(int g = 0; g < 3; g++) {
                        if(g == k) {
                            continue;
                        }
                        totalCosts[i][k] = Math.min(totalCosts[i][k], totalCosts[i - 1][g] + costs[i][k]);
                    }
                }
                //System.out.println("i: " + i + " - totalCosts: R: " + totalCosts[i][0] + " - B: " + totalCosts[i][1] + " - G: " + totalCosts[i][2]);
            }
            int[] costAtEnd = totalCosts[n - 1];
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++) {
                res = Math.min(res, costAtEnd[i]);
            }
            return res;
        }
    }
}
