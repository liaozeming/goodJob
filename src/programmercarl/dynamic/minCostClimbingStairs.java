package programmercarl.dynamic;

public class minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] 到达i 所花费的最小价值
        // dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
