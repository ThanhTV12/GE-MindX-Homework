package lesson19;

public class LeetCode72EditDistance {
    class Solution {
        int[][] minNUmbers;
        public int minDistance(String word1, String word2) {
            int n = word1.length();
            int m = word2.length();
            if(n == 0) {
                return m;
            }
            if(m == 0) {
                return n;
            }
            minNUmbers = new int[n][m];
            for(int i = 0;  i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(word1.charAt(i) == word2.charAt(j)) {
                        minNUmbers[i][j] = getNimNumber(i - 1, j- 1);
                    } else {
                        int number = getMumNumberInsert(i, j);
                        number = Math.min(number, getMumNumberReplace(i, j));
                        minNUmbers[i][j] = number;
                    }
                }
            }
            return minNUmbers[n - 1][m - 1];
        }

        private int getMumNumberInsert(int l, int r) {
            return Math.min(getNimNumber(l - 1, r), getNimNumber(l, r - 1)) + 1;
        }

        private int getMumNumberReplace(int l, int r) {
            return getNimNumber(l - 1, r -1) + 1;
        }

        private int getNimNumber(int l, int r) {
            if(l == -1 && r == -1) {
                return 0;
            }
            if(l == -1) {
                return r + 1;
            }
            if(r == -1) {
                return l + 1;
            }
            return minNUmbers[l][r];
        }
    }
}
