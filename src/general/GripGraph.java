package general;



public class GripGraph {

    private final int[] DR = {1, 0 , -1, 0};
    private final int[] DC = {0, 1 , 0, -1};
    private final int rowLength;
    private final int colLength;
    private final boolean[][] visited;
    private char[][] grid;

    public GripGraph(char[][] grid) {
        this.grid = grid;
        this.rowLength = grid.length;
        if(rowLength != 0) {
            this.colLength = grid[0].length;
        } else {
            this.colLength = 0;
        }
        this.visited = new boolean[rowLength][colLength];
    }

    /*
     *  iterate through by the depth first search on the graph(graph type is grip)
     *  dfs method to visit one specific node by the position(row, column)
     *  when visit the node if there are neighbor nodes with the value is '1', recursively def ones
     *  So we did visit the node and all adjacent nodes, all of them is a connected component;
     *  iterate through all land to find all island. If see any land was visited we break out to continue
     */
    public int findNumberOfConnectedComponents() {
        int numberOfIslands = 0;
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                if(grid[i][j] == '0') {
                    continue;
                }
                if(visited[i][j] == true) {
                    continue;
                }
                numberOfIslands++;
                dfs(grid, i, j);
            }
        }
        return numberOfIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(visited[r][c] == true) {
            return;
        }
        visited[r][c] = true;
        for(int i = 0; i < 4; i++) {
            int neighborR = r + DR[i];
            int neighborC = c + DC[i];
            if(neighborR >= 0 && neighborR < rowLength &&  neighborC >= 0 && neighborC < colLength
                    && visited[neighborR][neighborC] == false
                    && grid[neighborR][neighborC] == '1'
            ) {
                dfs(grid, neighborR, neighborC);
            }
        }
    }
}
