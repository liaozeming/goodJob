package programmercarl.dynamic;

public class maxUncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i < length1 + 1; i++) {
            int pointX = nums1[i-1];
            for (int j = 1; j < length2 + 1; j++) {
                int pointY = nums2[j-1];
                if (pointX == pointY) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
