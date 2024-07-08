package programmercarl.greedy;

public class maxProfit {
    //    public int maxProfit(int[] prices) {
//        int sum = 0;
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] - prices[i - 1] > 0) {
//                sum += prices[i] - prices[i - 1];
//            }
//        }
//        return sum;
//    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        int max = dp[0][0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            max = Math.max(dp[i][0], max);
        }
        return max;
    }
}
