package lesson17.dynamic_program;

public class Hw009LeetCode712MinimumASCIIDeleteSumForTwoStrings {
    class Solution {
        int[][] sums;
        public int minimumDeleteSum(String s1, String s2) {
            sums = new int[s1.length()][s2.length()];
            prefixSum1 = new int[s1.length()];
            prefixSum2 = new int[s2.length()];
            for(int i = 0; i < s1.length(); i++) {
                if(i == 0) {
                    prefixSum1[i] = s1.charAt(i);
                } else {
                    prefixSum1[i] = prefixSum1[i - 1] + s1.charAt(i);
                }
            }
            for(int i = 0; i < s2.length(); i++) {
                if(i == 0) {
                    prefixSum2[i] = s2.charAt(i);
                } else {
                    prefixSum2[i] = prefixSum2[i - 1] + s2.charAt(i);
                }
            }
            for(int i = 0; i < s1.length(); i++) {
                for(int j = 0; j < s2.length(); j++) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(j);
                    if(c1 == c2) {
                        sums[i][j] = getSum(i - 1, j - 1, c1, c2);
                    } else {
                        sums[i][j] = getSum(i - 1, j - 1, c1, c2) + c1 + c2;
                        sums[i][j] = Math.min(sums[i][j], getSum(i, j - 1, c1, c2) + c2);
                        sums[i][j] = Math.min(sums[i][j], getSum(i - 1, j, c1, c2) + c1);
                    }
                }
            }
            return sums[s1.length() - 1][s2.length() - 1];
        }


        int[] prefixSum1;
        int[] prefixSum2;
        public int getSum(int i, int j, char c1, char c2) {
            //System.out.println("i: " + i + " - j: " + j + " value: " + );
            int value;
            if(i == -1 && j == -1) {
                value = 0;
            } else if(i == -1) {
                value = prefixSum2[j];
            } else if(j == -1) {
                value = prefixSum1[i];
            } else {
                value = sums[i][j];
            }
            //System.out.println("i: " + i + " - j: " + j + " value: " + value);
            return value;
        }

    }
}
