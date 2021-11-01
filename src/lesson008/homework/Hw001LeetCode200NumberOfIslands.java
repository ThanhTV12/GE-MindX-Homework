package lesson008.homework;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hw001LeetCode200NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        Solution solution = new Solution();
        int numIslands = solution.numIslands(grid);
    }

    private static class Node implements Serializable {
        public int r;
        public int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static class Solution {
        public int numIslands(char[][] grid) {
            rowLength = grid.length;
            if (rowLength != 0) {
                colLength = grid[0].length;
            }
            visited = new boolean[rowLength][colLength];
            int numberOfIslands = 0;
            for(int i = 0; i < rowLength; i++) {
                for(int j = 0; j < colLength; j++) {
                    if(visited[i][j] == false && grid[i][j] == '1') {
                        numberOfIslands++;
                        bfs(grid, i, j);
                    }
                }
            }
            return numberOfIslands;
        }

        int rowLength = 0;
        int colLength = 0;

        int[] DR = {1, 0, -1 , 0};
        int[] DC = {0, 1, 0, -1};

        boolean[][] visited;
        Queue<Node> queue = new LinkedList<>();
        void bfs(char[][] grid, int r, int c) {
            queue.add(new Node(r, c));
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                if(visited[node.r][node.c] == true) {
                    continue;
                }
                visited[node.r][node.c] = true;
                for(int i = 0; i < 4; i++) {
                    int neighborR = node.r + DR[i];
                    int neighborC = node.c + DC[i];
                    if(neighborR >= 0 && neighborR < rowLength && neighborC >= 0 && neighborC < colLength
                            && visited[neighborR][neighborC] == false && grid[neighborR][neighborC] == '1') {
                        queue.add(new Node(neighborR, neighborC));
                    }
                }
            }
        }
    }
}
