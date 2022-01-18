package Lesson22_sercurity.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode207CourseSchedule {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean r = solution.canFinish(2, new int[][] {{1,0}, {0, 1}});
    }

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            visited = new boolean[numCourses];
            buildAdjList(numCourses, prerequisites);
            //find circle

            for(int i = 0; i < numCourses; i++) {
                if(visited[i]) {
                    continue;
                }
                inDfs = new boolean[numCourses];
                visited[i] = true;
                inDfs[i] = true;
                boolean existCircle = existCircleDfs(i);
                if(existCircle == true) {
                    return false;
                }
            }
            return true;
        }

        private boolean[] visited;
        private Map<Integer, List<Integer>> adjList = new HashMap();
        private boolean[] inDfs;

        void buildAdjList(int numCourses, int[][] prerequisites) {
            for(int i = 0; i < numCourses; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for(int i = 0; i < prerequisites.length; i++) {
                int first = prerequisites[i][0];
                int second = prerequisites[i][1];
                adjList.get(first).add(second);
            }
        }

        Boolean existCircleDfs(int source) {
            for(int dest : adjList.get(source)) {
                if(visited[dest] && inDfs[dest]) {
                    return true;    // there is a circle
                }
                if(visited[dest] == true) {
                    continue;
                }
                visited[dest] = true;
                inDfs[dest] = true;
                boolean isC = existCircleDfs(dest);

                if(isC == true) {
                    return isC;
                }
                inDfs[dest] = false;
            }
            return false;
        }
    }
}
