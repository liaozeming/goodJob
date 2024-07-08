package programmercarl.other;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        int maxLeft = 0;
        int maxRight = 0;
        int maxLength = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 1 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                    if (j - i == 1) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLeft = i;
                    maxRight = j;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    public static void main(String[] args) {
        longestPalindrome longestPalindrome = new longestPalindrome();
        longestPalindrome.longestPalindrome("aacabdkacaa");
    }
}
