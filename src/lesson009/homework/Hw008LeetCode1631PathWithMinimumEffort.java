package lesson009.homework;

public class Hw008LeetCode1631PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] heights = {{8,3,2,5,2,10,7,1,8,9},
                           {1,4,9,1,10,2,4,10,3,5},
                           {4,10,10,3,6,1,3,9,8,8},
                           {4,4,6,10,10,10,2,10,8,8},
                           {9,10,2,4,1,2,2,6,5,7},
                           {2,9,2,6,1,4,7,6,10,9},
                           {8,8,2,10,8,2,3,9,5,3},
                           {2,10,9,3,5,1,7,4,5,6},
                           {2,3,9,2,5,10,2,7,1,8},
                           {9,10,4,10,7,4,9,3,1,6}};
        solution.minimumEffortPath(heights);
    }

    private static class Solution {
        public int minimumEffortPath(int[][] heights) {
            rowLength = heights.length;
            if(rowLength == 0) {
                return 0;
            }
            if(rowLength > 0) {
                colLength = heights[0].length;
            }
            //Use BS from 0 to 10e6 to get the minimum effort
            int lo = 0;
            int hi = 6;
            int effort = 0;
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                isVisited = new boolean[rowLength][colLength];
                if(dfsWithEffort(heights, isVisited, mid, 0, 0)) {
                    effort = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return effort;
        }

        int rowLength;
        int colLength;
        int[] DR = new int[] {1, 0, -1, 0};
        int[] DC = new int[] {0, 1, 0, -1};
        boolean[][] isVisited;
        private boolean dfsWithEffort(int[][] heights, boolean[][] isVisited, int effort, int r, int c) {
            System.out.println("effort: " + effort + "- r: " + r + " c: " + c);
            if(isDestination(r , c)) {
                System.out.println("effort: " + effort + " is satified");
                return true;
            }
            isVisited[r][c] = true;
            for(int i = 0; i < 4; i++) {
                int nR = r + DR[i];
                int nC = c + DC[i];
                System.out.println("nR: " + nR + " - nC: " + nC);
                if(!checkNeighbor(nR, nC)) {
                    continue;
                }
                if(isVisited[nR][nC] == false && isMeetEffort(heights[r][c], heights[nR][nC], effort)) {
                    if(dfsWithEffort(heights, isVisited, effort, nR, nC)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean checkNeighbor(int nR, int nC) {
            if(nR < 0 || nR == rowLength || nC < 0 || nC == colLength) {
                return false;
            }
            return true;
        }

        private boolean isMeetEffort(int current, int neighbor, int effort) {
            return Math.abs(neighbor - current) <= effort;
        }

        private boolean isDestination(int nR, int nC) {
            if(nR == rowLength - 1 && nC == colLength - 1) {
                return true;
            }
            return false;
        }
    }
}
