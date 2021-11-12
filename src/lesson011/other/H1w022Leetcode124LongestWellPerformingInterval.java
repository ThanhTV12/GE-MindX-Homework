package lesson011.other;

public class H1w022Leetcode124LongestWellPerformingInterval {

    //brute force
    // time O(n*n)
    class Solution {
        public int longestWPI(int[] hours) {
            int res = 0;
            for(int i = 0; i < hours.length; i++) {
                int tiringday = 0;
                int nonTiringday = 0;
                for(int j = i; j < hours.length; j++) {
                    if(hours[j] > 8) {
                        tiringday++;
                    } else {
                        nonTiringday++;
                    }
                    if(tiringday > nonTiringday && res < tiringday + nonTiringday) {
                        res = tiringday + nonTiringday;
                    }
                }
            }
            return res;
        }
    }
}
