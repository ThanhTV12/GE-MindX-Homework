package lesson008.homework;

import java.util.LinkedList;
import java.util.Queue;

public class Hw010LeetCode1293ShortestPathInAGridV2 {

    public static void main(String[] args) {
        int[][] grid = new int[][] {{0,0,1,0,0,0,0,1,0,1,1,0,0,1,1},
                {0,0,0,1,1,0,0,1,1,0,1,0,0,0,1},
                {1,1,0,0,0,0,0,1,0,1,0,0,1,0,0},
                {1,0,1,1,1,1,0,0,1,1,0,1,0,0,1},
                {1,0,0,0,1,1,0,1,1,0,0,1,1,1,1},
                {0,0,0,1,1,1,0,1,1,0,0,1,1,1,1},
                {0,0,0,1,0,1,0,0,0,0,1,1,0,1,1},
                {1,0,0,1,1,1,1,1,1,0,0,0,1,1,0},
                {0,0,1,0,0,1,1,1,1,1,0,1,0,0,0},
                {0,0,0,1,1,0,0,1,1,1,1,1,1,0,0},
                {0,0,0,0,1,1,1,0,0,1,1,1,0,1,0}};
        Solution solution = new Solution();
        int shortest = solution.shortestPath(grid, 27);
        System.out.println(shortest);
    }

    private static class Solution {
        public int shortestPath(int[][] grid, int k) {
            //(r, c, k)
            rowLength = grid.length;
            if(rowLength != 0) {
                colLength = grid[0].length;
            }
            isVisited = new boolean[rowLength][colLength][k + 1];
            Node source = new Node(0, 0, k);
            Node dest = new Node(rowLength - 1, colLength - 1, 0);
            bfs(grid, source, dest);
            return minimumStep;
        }

        int[] DR = {1, 0, -1 , 0};
        int[] DC = {0, 1, 0, -1};
        boolean[][][] isVisited;
        int rowLength = 0;
        int colLength = 0;

        int minimumStep = 0;
        Queue<Node> queue = new LinkedList();
        private void bfs(int[][] grid, Node source, Node dest) {
            queue.add(source);
            isVisited[source.r][source.c][source.k] = true;
            while(!queue.isEmpty()) {
                minimumStep++;
                int currentSize = queue.size();
                System.out.println("currentSize: " + currentSize);
                for(int i = 0; i < currentSize; i++) {
                    Node node = queue.remove();
                    if(node.c == dest.c && node.r == dest.r) {
                        minimumStep--;
                        return;
                    }
                    for(int d = 0; d < 4; d++) {
                        int nR = node.r + DR[d];
                        int nC = node.c + DC[d];
                        if(nR < 0 || nR == rowLength || nC < 0 || nC == colLength) {
                            continue;
                        }
                        int nK = node.k - grid[nR][nC];
                        if(nK >= 0 && isVisited[nR][nC][nK] == false) {
                            isVisited[nR][nC][nK] = true;
                            queue.add(new Node(nR, nC, nK));
                        }
                    }
                }
            }
            minimumStep = 0;
        }
    }

    private static class Node {
        public int r;
        public int c;
        public int k;

        public Node(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
}
