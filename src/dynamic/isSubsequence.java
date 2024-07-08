package dynamic;

public class isSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        isSubsequence subsequence = new isSubsequence();
        boolean subsequence1 = subsequence.isSubsequence(s, t);
        System.out.println(subsequence1);
    }

    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for(int j = 0; j < t.length(); j++){
            dp[0][j] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            char char1 = s.charAt(i - 1);
            for (int j = 1; j <= t.length(); j++) {
                char char2 = t.charAt(j - 1);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
