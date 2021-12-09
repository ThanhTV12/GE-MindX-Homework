package Lesson15.mst_kruska;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hw002LeetCode1584MinCostToConnectAllPoints {
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            //caclute distance beetween each pair of 2 points
            // convert coordinate (x, y) -> t      t = x * 1000+ y
            int n = points.length; //  the number of points
            List<int[]> pairs = new ArrayList();
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    int postition1 = points[i][0] * 1000 + points[i][1];
                    int postition2 = points[j][0] * 1000 + points[j][1];
                    int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    pairs.add(new int[]{postition1, postition2, distance});
                }
            }
            //System.out.print(pairs);
            //Minimum spanning tree - KrusKal to min Cost of connections
            // Store all postion in decreasing order of distance
            Collections.sort(pairs, (a, b) -> Integer.compare(a[2], b[2]));
            int res = 0;
            int edges = 0;
            for(int[] pair : pairs) {
                int p1 = pair[0];
                int p2 = pair[1];
                int d = pair[2];

                int rootP1 = find(p1);
                int rootP2 = find(p2);
                if(rootP1 == rootP2) {
                    continue;
                }
                union(rootP1, rootP2);
                res += d;
                edges ++;
                if(edges == n - 1) {
                    return res;
                }
            }

            return res;
        }


        // Find - Union to add points into the tree
        Map<Integer, Integer> parents = new HashMap();
        Map<Integer, Integer> ranks = new HashMap();

        private int find(int p) {
            if(!parents.containsKey(p)) {
                parents.put(p, p);
                ranks.put(p, 0);
                return p;
            }
            if(parents.get(p) == p) {
                return p;
            }
            int parent = parents.get(p);
            int root = find(parent);
            parents.put(parent, root); // Path compression
            return root;
        }

        private void union(int rootU, int rootV) {
            int rankU = ranks.get(rootU);
            int rankV = ranks.get(rootV);
            if(rankU == rankV) {
                parents.put(rootV, rootU);
                ranks.put(rootU, ranks.get(rootU) + 1);
            } else if(rankU == rankV) {
                parents.put(rootV, rootU);
            } else {
                parents.put(rootU, rootV);
            }
        }
    }
}
