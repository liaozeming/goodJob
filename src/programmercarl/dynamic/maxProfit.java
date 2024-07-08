package programmercarl.dynamic;

public class maxProfit {
    public int maxProfit(int[] prices, int fee) {
        // 买入时扣除手续费
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -1 * fee - prices[0]; // 持有股票
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }
}
