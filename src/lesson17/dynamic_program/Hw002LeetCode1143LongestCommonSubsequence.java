package lesson17.dynamic_program;

//https://leetcode.com/problems/longest-common-subsequence/submissions/
public class Hw002LeetCode1143LongestCommonSubsequence {
    // DP
    // Step 1: define state => l[i][j] length of the logest common at text1[i] and text2[j]
    // Step 2: find relationship between problem and it subproblem
    // Step 3: base case

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int[][] l = new int[n + 1][m + 1];

            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < m + 1; j++) {
                    //System.out.println("i: " + i + " - c1: " + text1.charAt(i));
                    //System.out.println("j: " + j + " - c2: " + text1.charAt(j));
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        l[i][j] = l[i - 1][j - 1] + 1;
                    } else {
                        l[i][j] = Math.max(l[i][j - 1], l[i - 1][j]);
                    }
                    //System.out.println("i: " + i + " - j: " + j);
                    //System.out.println(l[i][j]);
                }
            }
            return l[n][m];
        }
    }
}
