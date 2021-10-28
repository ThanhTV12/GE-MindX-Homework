package general;

import java.util.List;

public class AdjListGraph {
    private List<List<Integer>> adjList;
    private boolean[] visited;

    public AdjListGraph(List<List<Integer>> adjList) {
        this.adjList = adjList;
        visited = new boolean[adjList.size()];
    }

    public int countTheNumberOfComponents() {
        int totalComponent = 0;
        for(int i = 0; i < adjList.size(); i++) {
            if(!visited[i]) {
                totalComponent++;
                dsf(adjList, i);
            }
        }
        return totalComponent;
    }


    private void dsf(List<List<Integer>> adjList, int cur) {
        visited[cur] = true;
        for(int next : adjList.get(cur)) {
            if(!visited[next]) {
                dsf(adjList, next);
            }
        }
    }
}
