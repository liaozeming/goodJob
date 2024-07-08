package programmercarl.dynamic;

public class integerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        integerBreak integerBreak = new integerBreak();
        int i = integerBreak.integerBreak(10);
        System.out.println(i);
    }
}
