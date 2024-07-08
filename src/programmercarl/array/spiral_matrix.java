package programmercarl.array;

public class spiral_matrix {
    public int[][] generateMatrix(int n) {
        int left = 0, top = 0;
        int right = n - 1, down = n - 1;
        int[][] res = new int[n][n];
        int k = 1;
        while (n / 2 > 0) {
            for (int i = left; i < right; i++, k++) {
                res[top][i] = k;
            }
            for (int i = top; i < down; i++, k++) {
                res[i][right] = k;
            }
            for (int i = right; i > left; i--, k++) {
                res[down][i] = k;
            }
            for (int i = down; i > top; i--, k++) {
                res[i][left] = k;
            }
            left++;
            right--;
            top++;
            down--;
            n -= 2;
        }
        if (n != 0) {
            res[res.length/ 2][res.length / 2] = k;
        }
        return res;
    }

    public static void main(String[] args) {
        spiral_matrix spiralMatrix = new spiral_matrix();
        int[][] ints = spiralMatrix.generateMatrix(3);
    }
}
