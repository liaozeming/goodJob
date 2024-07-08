package practice.其他;

public class maxAreaOfIsland {
    int count = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count = 0;
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                dfs(grid, visited, i, j);
                maxArea = Math.max(maxArea, count);
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i<0 ||  i>grid.length || j<0 || j>grid[0].length){
            return;
        }
        if (grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        count++;
        visited[i][j] = true;
        if (i + 1 < grid.length) {
            dfs(grid, visited, i + 1, j);
        }
        if (i - 1 >= 0) {
            dfs(grid, visited, i - 1, j);
        }
        if (j + 1 < grid[0].length) {
           dfs(grid, visited, i, j + 1);
        }
        if (j - 1 >= 0) {
           dfs(grid, visited, i, j + 1);
        }
    }


}
