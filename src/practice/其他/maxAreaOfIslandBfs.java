package practice.其他;

import java.util.ArrayDeque;
import java.util.Queue;

public class maxAreaOfIslandBfs {
    int count = 0;
    int row = 0;
    int col = 0;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                count = 0;
                bfs(grid, i, j, visited);
                maxArea = Math.max(maxArea, count);
            }
        }
        return maxArea;
    }

    private void bfs(int[][] grid, int i, int j, boolean[][] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i * grid[0].length + j);
        count++;
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            i = poll / col;
            j = poll % col;
            if (i + 1 < grid.length && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
                queue.add(getPosition(i + 1, j));
                visited[i + 1][j] = true;
                count++;
            }
            if (i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
                queue.add(getPosition(i - 1, j));
                visited[i - 1][j] = true;
                count++;
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
                queue.add(getPosition(i, j + 1));
                visited[i][j + 1] = true;
                count++;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
                queue.add(getPosition(i, j - 1));
                visited[i][j - 1] = true;
                count++;
            }
        }
    }

    public int getPosition(int i, int j) {
        return i * col + j;
    }
}
