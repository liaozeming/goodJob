package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens {
    public static void main(String[] args) {
        int n = 4;
        solveNQueens solveNQueens = new solveNQueens();
        List<List<String>> res = solveNQueens.solveNQueens(n);
        for (List<String> next : res) {
            next.forEach(System.out::print);
            System.out.println();
        }
    }

    List<List<String>> res = new ArrayList<>();
    StringBuilder tempBuilder = new StringBuilder();
    int n = 0;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        List<String> path = new ArrayList<>();
        boolean[][] used = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(used[i], false);
            tempBuilder.append(".");
        }
        backTrack(n, used, 0, path);
        return res;
    }

    private void backTrack(int n, boolean[][] used, int row, List<String> path) {
        if (n == row) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < n; i++) {
            if (!valid(used, row, i)) {
                continue;
            }
            used[row][i] = true;
            String temp = tempBuilder.toString();
            String queenRow = temp.substring(0, i) + "Q" + temp.substring(i + 1, temp.length());
            path.add(queenRow);
            backTrack(n, used, row + 1, path);
            used[row][i] = false;
            path.remove(path.size() - 1);
        }
    }

    private boolean valid(boolean[][] used, int row, int col) {
        // 列
        for (int i = 0; i < n; i++) {
            if (i != row && used[i][col]) {
                return false;
            }
        }
        // 斜边
        for (int i = 0; i < n; i++) {
            if (row - i >= 0 && col - i >= 0 && used[row - i][col - i]) {
                return false;
            }
            if (row - i >= 0 && col + i < n && used[row - i][col + i]) {
                return false;
            }
            if (row + i < n && col + i < n && used[row + i][col + i]) {
                return false;
            }
            if (row + i < n && col - i >= n && used[row + i][col - i]) {
                return false;
            }

        }
        return true;
    }
}
