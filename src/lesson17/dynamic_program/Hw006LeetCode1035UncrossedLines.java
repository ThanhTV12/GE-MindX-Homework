package lesson17.dynamic_program;

public class Hw006LeetCode1035UncrossedLines {
    // DP
// Step 1; Define state cL[i][j] => the maximum number of connecting lines we can draw at i-th nums1 and j-th nums2
// Step 2: Find relationship between cL[i][j] and it's subproblems => cL[i][j] = Max(1, cL[k][l]) with k < i and l < j and nums1[i] == nums[j] and nums1[k] == nums[l]
// Step 3: base cases => initiate cL[i][j] = 0
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            // initiate
            int[][] cL = new int[nums1.length][nums2.length];
            // Buttom - up
            for(int i = 0; i < nums1.length; i++) {
                for(int j = 0; j < nums2.length; j++) {
                    if(nums1[i] == nums2[j]) {
                        if(i * j == 0) {
                            cL[i][j] = 1;
                        } else {
                            cL[i][j] = cL[i - 1][j - 1] + 1;
                        }
                    } else {
                        if(i + j == 0) {
                            cL[i][j] = 0;
                        } else if(i == 0) {
                            cL[i][j] = cL[i][j - 1];
                        } else if(j == 0) {
                            cL[i][j] = cL[i - 1][j];
                        } else {
                            cL[i][j] = Math.max(cL[i - 1][j], cL[i][j - 1]);
                        }
                    }
                }
            }
            return cL[nums1.length - 1][nums2.length - 1];
        }
    }
}
