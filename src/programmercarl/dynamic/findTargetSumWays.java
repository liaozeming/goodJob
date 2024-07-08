package programmercarl.dynamic;

import java.util.Arrays;

public class findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        // -a + b =target  a + b = sum
        int sum = Arrays.stream(nums).sum();
        int twoPositiveSum = target + sum;
        if (twoPositiveSum % 2 != 0) {
            return 0;
        }
        target = twoPositiveSum / 2;
        if (target < 0) {
            return 0;
        }
        // dp[i][j] 从0-i 个物品选出j个质量的方法数
        // dp[i][j] = dp[i-1][j] + dp[i][j-num[i]]
        int[][] dp = new int[nums.length][target + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= target; i++) {
            if (nums[0] == i) {
                dp[0][i] += 1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        int[] nums = {100};
        findTargetSumWays findTargetSumWays = new findTargetSumWays();
        findTargetSumWays.findTargetSumWays(nums, -200);
    }
}
