package lesson14;

import java.util.ArrayList;
import java.util.List;

public class Hw004LeetCode305NumberOfIslands2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 8;
        int n = 2;
        int[][] postions = new int[][]{{7,2}};
        List<Integer> integers = solution.numIslands2(m, n, postions);
    }

    private static class Solution {

        int[] DR = {1, 0 , -1 , 0};
        int[] DC = {0, 1 ,  0 , -1};
        int EMPTY_VALUE = -1;
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            if(positions.length == 0) {
                return new ArrayList();
            }
            List<Integer> res = new ArrayList();
            int current = 0;
            parents = new int[m * n];
            MR = m;
            for(int i = 0; i < m * n; i++) {
                parents[i] = EMPTY_VALUE;
            }
            ranks = new int[m * n];
            for(int[] position : positions) {
                current++;
                int r = position[0];
                int c = position[1];
                int ele = addNew(r, c);
                for(int i = 0; i < 4; i++) {
                    int nR = r + DR[i];
                    int nC = c + DC[i];
                    if(nR < 0 || nR == m || nC < 0 || nC == n) {
                        continue;
                    }
                    int nKey = getKey(nR, nC);
                    int rootOfN = find(nKey);
                    if(rootOfN == EMPTY_VALUE) {
                        continue;
                    }
                    int rootEle = find(ele);
                    if(rootEle == rootOfN) {
                        continue;
                    }
                    union(rootEle, rootOfN);
                    current--;
                }
                res.add(current);
            }
            return res;
        }

        int[] parents;
        int[] ranks;
        int MR;

        private int addNew(int r, int c) {
            int key = getKey(r, c);
            parents[key] = key;
            return key;
        }

        private int find(int hashedPostion) {
            if(parents[hashedPostion] == EMPTY_VALUE) {
                return EMPTY_VALUE;
            }
            if(parents[hashedPostion] == hashedPostion) {
                return hashedPostion;
            }
            parents[hashedPostion] = find(parents[hashedPostion]);
            return parents[hashedPostion];
        }


        private void union(int rootU, int rootV) {
            if(rootU == rootV) {
                return;
            }
            if(ranks[rootU] == ranks[rootV]) {
                parents[rootV] = rootU;
                ranks[rootU] = ranks[rootU] + 1;
                return;
            }
            if(ranks[rootU] > ranks[rootV]) {
                parents[rootV] = rootU;
                return;
            }
            parents[rootU] = rootV;
        }

        private int getKey(int r, int c) {
            return MR * r + c;
        }
    }
}
