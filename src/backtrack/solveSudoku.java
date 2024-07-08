package backtrack;

public class solveSudoku {
    public static void main(String[] args) {
        char[][] board =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        solveSudoku solveSudoku = new solveSudoku();
        solveSudoku.solveSudoku(board);
        System.out.println(board);
    }

    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    private void backTrack(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                //找到是数字空格  将空格变为数字
                for (char num = '1'; num < '9'; num++) {
                    if (!valid(board, i, j, num)) {
                        continue;
                    }
                    board[i][j] = num;
                    //最后一行
                    if (i == 8) {
                        return;
                    }
                    backTrack(board, i, j);
                    board[i][j] = '.';
                }

            }
        }
    }

    private boolean valid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        for (int j = 0; j < col; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

}
