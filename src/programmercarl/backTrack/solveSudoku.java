package programmercarl.backTrack;

public class solveSudoku {
    public void solveSudoku(char[][] board) {
        int row = 0;
        int col = 0;
        backTrack(row, col, board);
    }

    private boolean backTrack(int row, int col, char[][] board) {
        if (row == board.length && col == board.length) {
            return true;
        }
        for (int j = col; j < board.length; j++) {
            if (board[row][j] != '.') { // 跳过原始数字
                continue;
            }
            for (char num = '1'; num <= '9'; num++) {
                if (isValidSudoku(row, j, num, board)) {
                    board[row][j] = num;
                    if (j == board.length - 1) {
                        backTrack(row + 1, 0, board);
                    } else {
                        backTrack(row, j + 1, board);
                    }
                    board[row][j] = '.';
                }
            }
            return false;
        }
        return true;
    }

    private boolean isValidSudoku(int row, int col, char val, char[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
