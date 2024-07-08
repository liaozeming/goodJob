package programmercarl.other;

import static sun.nio.ch.IOStatus.check;

public class totalNQueens {
    int total = 0;

    public int totalNQueens(int n) {
        int row = 0;
        boolean[][] used = new boolean[n][n];
        dfs(row, n, used);
        return total;
    }

    private void dfs(int row, int n, boolean[][] used) {
        if (row == n) {
            total++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(row, col, used)) {
                used[row][col] = true;
                dfs(row + 1, n, used);
                used[row][col] = false;
            }
        }
    }

    private boolean check(int row, int col, boolean[][] used) {
        for (int i = 0; i < row; i++) {
            if (used[i][col]) {
                return false;
            }
        }
        int k = 1;
        while (row - k >= 0) {
            if (col + k < used.length && used[row - k][col + k]) {
                return false;
            }
            if (col - k >= 0 && used[row - k][col - k]) {
                return false;
            }
            k++;
        }
        return true;
    }

    public static void main(String[] args) {
        totalNQueens totalNQueens = new totalNQueens();
        totalNQueens.totalNQueens(4);
    }
}
