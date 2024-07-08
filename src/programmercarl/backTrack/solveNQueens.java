package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;

public class solveNQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] chess = new boolean[n][n];
        List<String> temp = new ArrayList<>();
        backTrack(0, n, chess, temp);
        return res;
    }

    private void backTrack(int row, int n, boolean[][] chess, List<String> temp) {
        if (row == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 检查第row行第i列能否放皇后
            if (check(row, i, chess)) {
                chess[row][i] = true;
                //第i列放皇后
                temp.add(getQueenString(i, n));
                backTrack(row + 1, n, chess, temp);
                temp.remove(temp.size() - 1);
                chess[row][i] = false;
            }
        }
    }

    // 检查当前位置是否能放入
    // 同一行 同一列 同一斜线  同一行上面代码已包括
    private boolean check(int row, int col, boolean[][] chess) {
        // 列
        for (int i = 0; i < chess.length; i++) {
            if (i != row && chess[i][col]) {
                return false;
            }
        }
        // 斜线
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (Math.abs(row - i )== Math.abs(col - j) && i != row && chess[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private String getQueenString(int col, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                stringBuilder.append("Q");
            } else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }
}
