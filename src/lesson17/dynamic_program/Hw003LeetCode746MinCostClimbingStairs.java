package lesson17.dynamic_program;

public class Hw003LeetCode746MinCostClimbingStairs {
    // use DP
// Step 1: define state => minCost[i] the min cost at i-the  star
// Step 2: Find the relationship between the problem and it's problem => minCost[i] = min(cost[i - 1], cost[i - 2]) + cost[i]
// Step 3: Find base cases: minCost[0] = cost[0];  minCost[1] = cost[1]

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if(cost.length == 1) {
                return cost[0];
            }
            int[] minCost = new int[cost.length];
            minCost[0] = cost[0];
            minCost[1] = cost[1];
            for(int i = 2; i < cost.length; i++) {
                minCost[i] = Math.min(minCost[i - 1], minCost[i - 2]) + cost[i];
            }
            return Math.min(minCost[cost.length - 1], minCost[cost.length - 2]);
        }
    }
}
