package lesson17.dynamic_program;

public class Hw008LeetCode718MaximumLengthOfRepeatedSubarray {
    // DP
    // Step 1: Identify state: length[i][j] the length of subarray at i-th of nums1 and j-th of nums2
    // Step 2: Find relationship between length[i][j] and length[i - 1][j - 1]
    // if(nums[i] == nums[j]) => length[i][j] = length[i - 1][j - 1] + 1 else length[i][j] = 0
    // Step 3: base cases => initiate length[i][j] = 0

    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int[][] length = new int[nums1.length][nums2.length];
            //Butoom up
            int maxLength = 0;
            for(int  i = 0; i < nums1.length; i++) {
                for(int j = 0; j < nums2.length; j++) {
                    if(nums1[i] == nums2[j]) {
                        if(i * j == 0) {
                            length[i][j] = 1;
                        } else {
                            length[i][j] = length[i - 1][j - 1] + 1;
                        }
                        maxLength = Math.max(maxLength, length[i][j]);
                    } else {
                        length[i][j] = 0;
                    }
                }
            }
            return maxLength;
        }
    }
}
