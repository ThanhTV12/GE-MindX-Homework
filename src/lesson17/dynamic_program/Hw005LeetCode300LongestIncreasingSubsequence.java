package lesson17.dynamic_program;

public class Hw005LeetCode300LongestIncreasingSubsequence  {
    //Use DP
    // Step 1: Identify the state. l[i] => the length of the longest strictly increasing subsequence
    // Step 2: Find relationship between problem and subproblem => l[i] = Max(1, l[j]) with j < i and nums[j] < nums[i]
    // Step 3: base cases => l[0] = 1;
    // Time O(n * n)
    // Space O(n)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            // initiate
            int[] l = new int[nums.length];
            l[0] = 1;
            int res = 1;
            // bottom-up
            for(int i = 0; i < nums.length; i++) {
                l[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]) {
                        l[i] = Math.max(l[i], l[j] + 1);
                    }
                    res = Math.max(res, l[i]);
                }
            }
            return res;
        }
    }
}
