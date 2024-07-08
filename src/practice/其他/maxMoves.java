package practice.其他;

public class maxMoves {
    public static void main(String[] args) {
        int[][] grid = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        maxMoves maxMoves = new maxMoves();
        int i = maxMoves.maxMoves(grid);
        System.out.println(i);
    }

    int count = 0;

    public int maxMoves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (j >= grid[0].length) {
            return;
        }
        count = Math.max(count, j);
        for (int k = -1; k <= 1; k++) {
            if (i + k < 0 || i + k >= grid.length || j + 1 >= grid[0].length || grid[i + k][j + 1] <= grid[i][j]) {
                continue;
            }
            dfs(grid, i + k, j + 1);
        }
    }
}
