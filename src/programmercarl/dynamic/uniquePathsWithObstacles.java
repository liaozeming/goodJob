package programmercarl.dynamic;

public class uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean rowFlag = false;
        boolean colFlag = false;
        for (int i = 0; i < m; i++) {
            if (rowFlag) {
                dp[i][0] = 0;
                continue;
            }
            if (obstacleGrid[i][0] == 1) {
                rowFlag = true;
                dp[i][0] = 0;
                continue;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (colFlag) {
                dp[0][i] = 0;
                continue;
            }
            if (obstacleGrid[0][i] == 1) {
                colFlag = true;
                dp[0][i] = 0;
                continue;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
