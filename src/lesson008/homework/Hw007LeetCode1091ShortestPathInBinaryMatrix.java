package lesson008.homework;

import java.util.LinkedList;
import java.util.Queue;

public class Hw007LeetCode1091ShortestPathInBinaryMatrix {
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if(grid.length == 0) {
                return -1;
            }
            length = grid.length;
            if(grid[0][0] == 1 || grid[length - 1][length - 1] == 1) {
                return -1;
            }
            Node source = new Node(0, 0);
            Node dest = new Node(length - 1, length - 1);
            isVisited = new boolean[length][length];
            bfs(grid, source, dest);
            return path;
        }

        int[] DR = new int[] {1, 1, 0, -1, -1 , -1 , 0 , 1};
        int[] DC = new int[] {0, 1,  1,  1,  0 , -1 , -1 , -1};
        int length;
        boolean[][] isVisited;
        Queue<Node> queue = new LinkedList();
        int path = 0;
        private void bfs(int[][] grid, Node source, Node dest) {
            queue.add(source);
            isVisited[source.r][source.c] = true;
            while(!queue.isEmpty()) {
                int currentSize = queue.size();
                path++;
                for(int j = 0; j < currentSize; j++) {
                    Node node = queue.remove();
                    if(node.r == dest.r && node.c == dest.c) {
                        return;
                    }
                    for(int i = 0; i < 8; i++) {
                        int nR = node.r + DR[i];
                        int nC = node.c + DC[i];
                        if(nR >= 0  && nR < length && nC >= 0  && nC < length
                                && isVisited[nR][nC] == false
                                && grid[nR][nC] == 0) {
                            isVisited[nR][nC] = true;
                            queue.add(new Node(nR, nC));
                        }
                    }
                }
            }
            path = -1;
            return;
        }
    }

    class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
