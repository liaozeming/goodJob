package programmercarl.dynamic;

import java.util.Arrays;

public class canPartition {
//    public boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if (sum % 2 != 0) {
//            return false;
//        }
//        sum /= 2;
//        //从物品中算出和为sum的最大价值
//        int[][] dp = new int[nums.length][sum + 1];
//        for (int i = 0; i <= sum; i++) {
//            if (i >= nums[0]) {
//                dp[0][i] = nums[0];
//            }
//        }
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j <= sum; j++) {
//                if (j < nums[i]) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
//                }
//            }
//        }
//        return dp[nums.length - 1][sum] == sum;
//    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int[] dp = new int[sum + 1];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= nums[0]) {
                dp[i] = nums[0];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum] == sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        canPartition canPartition = new canPartition();
        canPartition.canPartition(nums);
    }
}
