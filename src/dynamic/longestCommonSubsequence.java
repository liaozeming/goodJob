package dynamic;

public class longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            char char1 = text1.charAt(i);
            for (int j = 1; j < text2.length() + 1; j++) {
                char char2 = text2.charAt(j);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
