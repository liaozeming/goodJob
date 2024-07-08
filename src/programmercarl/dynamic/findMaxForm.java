package programmercarl.dynamic;

import java.util.ArrayList;
import java.util.List;

public class findMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 0; i < strs.length; i++) {
            int zeroStrCount = getZeroCount(strs[i]);
            int oneStrCount = strs[i].length() - zeroStrCount;
            for (int j = m; j >= zeroStrCount; j--) {
                for (int k = n; k >= oneStrCount; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroStrCount][k - oneStrCount] + 1);
                }
            }
        }
        return dp[m][n];
    }


    private int getZeroCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        findMaxForm findMaxForm = new findMaxForm();
        findMaxForm.findMaxForm(strs, 5, 3);
    }
}
